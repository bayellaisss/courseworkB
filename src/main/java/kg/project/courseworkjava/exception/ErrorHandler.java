package kg.project.courseworkjava.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse entityNotFoundException(EntityNotFoundException entityNotFoundException) {
        return new ErrorResponse(entityNotFoundException.getMessage());
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse alreadyExistsException(AlreadyExistsException alreadyExistsException) {
        return new ErrorResponse(alreadyExistsException.getMessage());
    }




}