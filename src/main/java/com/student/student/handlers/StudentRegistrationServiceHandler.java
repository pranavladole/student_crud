package com.student.student.handlers;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentRegistrationServiceHandler {

public ResponseEntity<String> sQLIntegrityConstraintViolationException(RuntimeException sqlException){
    return new ResponseEntity<String>( sqlException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}

}
