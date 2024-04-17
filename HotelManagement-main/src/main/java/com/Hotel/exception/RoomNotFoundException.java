package com.Hotel.exception;

public class RoomNotFoundException extends RuntimeException {


    public RoomNotFoundException(String customMessage) {
        super(customMessage);
    }
}
