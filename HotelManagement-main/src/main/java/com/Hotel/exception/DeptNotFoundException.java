package com.Hotel.exception;


public class DeptNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeptNotFoundException() {
        super();
    }

    public DeptNotFoundException(String customMessage) {
        super(customMessage);
    }
}
