package org.rhworkstation.exception;

public class RHException extends Exception {

    public RHException(String message) {
        super(message);
    }

    public RHException(String message, Throwable cause) {
        super(message, cause);
    }
}