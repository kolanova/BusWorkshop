package com.BusWorkshop.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.LocalDateTime;
import java.util.Date;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ResourceNotFound.class})
    protected HttpErrorResponse handleGenericException(ResourceNotFound exception) {
        return new HttpErrorResponse(
                404,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({DuplicatedNameBusException.class})
    public HttpErrorResponse handleGenericException(DuplicatedNameBusException exception) {
        return new HttpErrorResponse(
                409,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler({TeamNotAvailable.class})
    public HttpErrorResponse handleGenericException(TeamNotAvailable exception) {
        return new HttpErrorResponse(
                503,
                exception.getMessage(),
                LocalDateTime.now()
        );
    }
}
