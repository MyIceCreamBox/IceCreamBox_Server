package com.example.myicecreambox.user.controller;

import com.example.myicecreambox.global.dto.ResponseCustom;
import com.example.myicecreambox.user.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class UserExceptionController {
    /**
     * User Exceptions
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseCustom<?> catchUserNotFoundException(UserNotFoundException e) {
        log.error(e.getMessage());
        return ResponseCustom.NOT_FOUND(e.getMessage());
    }

    @ExceptionHandler(InvalidUserNickNameException.class)
    public ResponseCustom<?> catchInvalidUserNickNameException(InvalidUserNickNameException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(AlreadyExistEmailException.class)
    public ResponseCustom<?> catchAlreadyExistEmailException(AlreadyExistEmailException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(InvalidLoginRequestException.class)
    public ResponseCustom<?> catchInvalidLoginRequestException(InvalidLoginRequestException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(PasswordNotMatchException.class)
    public ResponseCustom<?> catchPasswordNotMatchException(PasswordNotMatchException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(InvalidUserEmailException.class)
    public ResponseCustom<?> catchInvalidUserEmailException(InvalidUserEmailException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(TokenExpirationException.class)
    public ResponseCustom<?> catchTokenExpirationException(TokenExpirationException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }

    @ExceptionHandler(AuthAnnotationIsNowhereException.class)
    public ResponseCustom<?> catchAuthAnnotationIsNowhereException(AuthAnnotationIsNowhereException e) {
        log.error(e.getMessage());
        return ResponseCustom.BAD_REQUEST(e.getMessage());
    }
}
