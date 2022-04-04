package ca.me.proj.controller.exception;

import com.fasterxml.jackson.core.JsonParseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ca.me.proj.dtos.error.ApiError;
import ca.me.proj.exceptions.ResourceAlreadyExistsException;
import ca.me.proj.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    private ApiError createApiError(String message, Throwable cause, HttpStatus status) {
        ApiError error = new ApiError(message, cause, status.value());
        log.error("Error: {}", error);
        return error;
    }

    @ExceptionHandler(
            value = {ResourceNotFoundException.class, ResourceAlreadyExistsException.class})
    public ResponseEntity<ApiError> preconditionFailed(Exception ex) {
        return new ResponseEntity<>(
                createApiError(ex.getMessage(), ex.getCause(), HttpStatus.PRECONDITION_FAILED),
                HttpStatus.PRECONDITION_FAILED);
    }

    @ExceptionHandler(value = {JsonParseException.class, DataIntegrityViolationException.class})
    public ResponseEntity<ApiError> badRequest(Exception ex) {
        return new ResponseEntity<>(
                createApiError(ex.getMessage(), ex.getCause(), HttpStatus.BAD_REQUEST),
                HttpStatus.BAD_REQUEST);
    }

}
