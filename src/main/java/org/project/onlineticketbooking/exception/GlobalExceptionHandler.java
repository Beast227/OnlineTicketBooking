package org.project.onlineticketbooking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> handleUserNotFound(UserNotFound userNotFound) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(userNotFound.getMessage());
    }

    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> handleInvalidCredentials(InvalidCredentials invalidCredentials) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(invalidCredentials.getMessage());
    }

}
