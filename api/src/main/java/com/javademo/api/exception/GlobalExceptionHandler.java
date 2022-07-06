package com.javademo.api.exception;

import com.javademo.common.api.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    public Result<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        return Result.error(HttpStatus.PRECONDITION_FAILED, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleIllegalArgumentException(Exception exception) {
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
