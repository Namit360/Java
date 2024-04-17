package com.Hotel.exception;


public class GuestNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GuestNotFoundException() {
        super();
    }

    public GuestNotFoundException(String customMessage) {
        super(customMessage);
    }
}
