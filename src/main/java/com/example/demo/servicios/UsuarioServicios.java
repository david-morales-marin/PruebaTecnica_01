package com.example.demo.servicios;

import com.example.demo.modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repositorio.Repositorio;
@RestController
public abstract class UsuarioServicios {
    @Autowired
    private Repositorio repositorio;
    public Usuario newUser (Usuario usuario){
        return repositorio.save(usuario);
    }
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario){
        return this.repositorio.save(usuario);
    }
    public abstract Usuario obtenerPorIdentificacion(String identificacion);
    public abstract Usuario update(Usuario usuarioActual);
}
