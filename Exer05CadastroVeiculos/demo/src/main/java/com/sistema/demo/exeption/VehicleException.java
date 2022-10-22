package com.sistema.demo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class VehicleException extends Exception{

    private static final long serialVersionUID = 1L;
    //    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Object Not Found")
    public VehicleException (String message) {
        super(message);
    }
}
