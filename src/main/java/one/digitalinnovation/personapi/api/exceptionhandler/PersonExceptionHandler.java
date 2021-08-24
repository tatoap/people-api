package one.digitalinnovation.personapi.api.exceptionhandler;

import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.PropertyBindingException;
import one.digitalinnovation.personapi.exception.BusinessException;
import one.digitalinnovation.personapi.exception.EntityNotFoundException;
import org.flywaydb.core.internal.util.ExceptionUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class PersonExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String MSG_INVALID_FIELDS = "One or more fields are invalid, please fill in correctly and try again";

    private static final String MSG_INVALID_REQUEST = "The body of request is invalid, please check syntax errors.";

    private static final String MSG_PROPERTY_NOT_EXISTS = "The property '%s' not exists. Please check "
            + "the request send and try again.";

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                            HttpHeaders headers, HttpStatus status, WebRequest request) {
        Throwable rootCause = ExceptionUtils.getRootCause(ex);

        if (rootCause instanceof NoHandlerFoundException) {
            return handleNoHandlerFoundException((NoHandlerFoundException) rootCause, headers, status, request);
        }

        if (rootCause instanceof PropertyBindingException) {
            return handlePropertyBinding((PropertyBindingException) rootCause, headers, status, request);
        }

        if (rootCause instanceof MethodArgumentNotValidException) {
            return handleMethodArgumentNotValid((MethodArgumentNotValidException) rootCause, headers,status, request);
        }

        ProblemType problemType = ProblemType.ININTELIGIBLE_MESSAGE;

        String details = MSG_INVALID_REQUEST;

        Problem problem = createProblemBuilder(status, problemType, details)
                .userMessage(details)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return handleValidationInternal(ex, ex.getBindingResult(), new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                            HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.REQUEST_NOT_FOUND;

        String detail = String.format("Resource '%s' you tried to access does not exist", ex.getRequestURL());

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private ResponseEntity<Object> handlePropertyBinding(PropertyBindingException ex, HttpHeaders headers,
                           HttpStatus status, WebRequest request) {
        ProblemType problemType = ProblemType.ININTELIGIBLE_MESSAGE;

        String path = joinPath(ex.getPath());

        String details = String.format(MSG_PROPERTY_NOT_EXISTS, path);

        Problem problem = createProblemBuilder(status, problemType, details)
                .userMessage(details)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleBusiness(BusinessException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        ProblemType problemType = ProblemType.ERR_BUSINESS;

        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        ProblemType problemType = ProblemType.REQUEST_NOT_FOUND;

        String detail = ex.getMessage();

        Problem problem = createProblemBuilder(status, problemType, detail)
                .userMessage(detail)
                .build();

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType problemType, String detail) {

        return Problem.builder()
                .timestamp(OffsetDateTime.now())
                .status(status.value())
                .type(problemType.getUri())
                .title(problemType.getTitle())
                .detail(detail);
    }

    private ResponseEntity<Object> handleValidationInternal(Exception ex, BindingResult bindingResult,
                           HttpHeaders headers, HttpStatus status, WebRequest request) {

        ProblemType problemType = ProblemType.INVALID_DATA;

        String detail = MSG_INVALID_FIELDS;

        List<Problem.Object> problemObjects = bindingResult.getAllErrors().stream()
                .map(objectError -> {
                    String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());

                    String name = objectError.getObjectName();

                    if (objectError instanceof FieldError) {
                        name = ((FieldError) objectError).getField();
                    }

                    return Problem.Object.builder()
                            .name(name)
                            .userMessage(message)
                            .build();
                })
                .collect(Collectors.toList());

        Problem problem = createProblemBuilder(status, problemType,detail)
                .userMessage(detail)
                .objects(problemObjects)
                .build();

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    private String joinPath(List<Reference> reference) {
        return reference.stream()
                .map(ref -> ref.getFieldName())
                .collect(Collectors.joining("."));
    }
}
