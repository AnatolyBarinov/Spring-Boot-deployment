package org.example.error;
import org.example.Controller.InvalidCredentials;
import org.example.Controller.UnauthorizedUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<Object> handleInvalidCredentials(InvalidCredentials ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<Object> handleUnauthorizedUser(UnauthorizedUser ex, WebRequest request) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        System.out.println(ex.getMessage());  // Запись в консоль сообщения из исключения
        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}