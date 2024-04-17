package com.Hotel.exception;


public class ReservationNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ReservationNotFoundException() {
        super();
    }

    public ReservationNotFoundException(String customMessage) {
        super(customMessage);
    }
}