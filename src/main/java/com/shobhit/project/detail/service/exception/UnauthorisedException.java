package com.shobhit.project.detail.service.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnauthorisedException extends RuntimeException {

    public UnauthorisedException(String message) {
        super(message);

    }
}

