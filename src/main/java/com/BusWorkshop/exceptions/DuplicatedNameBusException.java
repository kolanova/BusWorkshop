package com.BusWorkshop.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Name already Exists, it needs to be Unique")
public class DuplicatedNameBusException extends RuntimeException{
    public DuplicatedNameBusException(String message) {
        super(message);

    }
}