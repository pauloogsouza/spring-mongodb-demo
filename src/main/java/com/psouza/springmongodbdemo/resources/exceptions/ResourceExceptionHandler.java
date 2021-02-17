package com.psouza.springmongodbdemo.resources.exceptions;

import com.psouza.springmongodbdemo.services.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        String error = "Not found";
        int status = HttpStatus.NOT_FOUND.value();
        StandardError err = new StandardError(Instant.now(), status, error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
