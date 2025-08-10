package br.com.api.ajude.exceptions;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class FlowException extends RuntimeException {

    private final HttpStatus status;
    private final LocalDateTime timestamp;
    private final String message;

    public FlowException(HttpStatus status, String message) {
        super(message);
        this.status = status != null ? status : HttpStatus.BAD_REQUEST;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public FlowException(HttpStatus status, String message, Throwable cause) {
        super(message, cause);
        this.status = status != null ? status : HttpStatus.BAD_REQUEST;
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }
}
