package com.BusWorkshop.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE, reason = "Maintenance time not available")
public class TeamNotAvailable extends RuntimeException{
    public TeamNotAvailable(String message) {
        super(message);
    }
}
