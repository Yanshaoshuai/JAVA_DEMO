package com.javademo.api.exception;

import com.javademo.api.controller.ApiController;
import com.javademo.common.api.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private final static Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    public Result<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        LOG.error("error occurs",exception);
        return Result.error(HttpStatus.PRECONDITION_FAILED, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<?> handleIllegalArgumentException(Exception exception) {
        LOG.error("error occurs",exception);
        return Result.error(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
