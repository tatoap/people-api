package one.digitalinnovation.personapi.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class CPFAlreadyIncludeException extends BusinessException {

    private static final long serialVersionUID = 1L;
    private static final String MSG_CPF_ALREADY_INCLUDED = "CPF with number %s already included on system";

    public CPFAlreadyIncludeException(String cpf) {
        super(String.format(MSG_CPF_ALREADY_INCLUDED, cpf));
    }

}
