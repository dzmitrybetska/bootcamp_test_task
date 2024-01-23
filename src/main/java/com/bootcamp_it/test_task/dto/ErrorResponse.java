package com.bootcamp_it.test_task.dto;

import com.bootcamp_it.test_task.errors.Error;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {

    private final Integer errorCount;
    private final List<Error> errors;
    private final LocalDateTime time;
    private final HttpStatus status;
}
