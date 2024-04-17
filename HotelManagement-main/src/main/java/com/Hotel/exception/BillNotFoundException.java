package com.Hotel.exception;


public class BillNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BillNotFoundException() {
        super();
    }

    public BillNotFoundException(String customMessage) {
        super(customMessage);
    }
}
