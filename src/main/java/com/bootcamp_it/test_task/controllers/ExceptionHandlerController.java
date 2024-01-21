package com.bootcamp_it.test_task.controllers;

import com.bootcamp_it.test_task.dto.ErrorResponse;
import com.bootcamp_it.test_task.errors.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

import static com.bootcamp_it.test_task.utils.Constants.EXCEPTION;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException exception) {
        log.warn(EXCEPTION, exception.getMessage());
        return buildErrorResponse(exception);
    }

    private ErrorResponse buildErrorResponse(MethodArgumentNotValidException exception) {
        return ErrorResponse.builder()
                .errorCount(exception.getFieldErrorCount())
                .time(LocalDateTime.now())
                .status(BAD_REQUEST)
                .errors(buildValidationErrors(exception))
                .build();
    }

    private List<Error> buildValidationErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors()
                .stream()
                .map(this::getError)
                .toList();
    }

    private Error getError(FieldError fieldError) {
        return new Error(fieldError.getField(), fieldError.getDefaultMessage());
    }
}
