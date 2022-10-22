package com.sistema.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceResponse {

    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<String> handleEmptyImput(VehicleException vehicleException) {
        return new ResponseEntity<String>(vehicleException.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
