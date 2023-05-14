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
//    @ExceptionHandler(UserNicknameNotFoundException.class)
//    public ResponseCustom<?> catchUserNicknameNotFoundException(UserNicknameNotFoundException e) {
//        log.error(e.getMessage());

//        return ResponseCustom.NOT_FOUND(e.getMessage());
//    }
//    @ExceptionHandler(AccessDeniedUserException.class)
//    public ResponseCustom<?> catchAccessDeniedUserException(AccessDeniedUserException e) {
//        log.error(e.getMessage());

//        return ResponseCustom.FORBIDDEN(e.getMessage());

//    }
}
