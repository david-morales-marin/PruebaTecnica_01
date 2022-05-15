package com.example.demo.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class RestIncorrecta extends RuntimeException{

    private static final long serialVersionUID = 1l;
    private final int codigo;
    public RestIncorrecta(int codigo, String mensaje){
        super(mensaje);
        this.codigo = codigo;
    }

    public int getCodigo(){ return codigo; }
}
