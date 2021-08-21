package one.digitalinnovation.personapi.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERR_BUSINESS("/err-business", "Business violation rule"),
    INVALID_DATA("/invalid-data", "Invalid data"),
    REQUEST_NOT_FOUND("//request-not-found", "Request not found");

    private String title;
    private String uri;

    ProblemType(String uri, String title) {
        this.uri = "https://personapi.com" + uri;
        this.title = title;
    }
}
