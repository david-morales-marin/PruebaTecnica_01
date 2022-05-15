package com.example.demo.controlador;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.Repositorio;
import com.example.demo.servicios.UsuarioServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
    @Autowired
    private Repositorio repositorio;
    @Autowired
    UsuarioServicios usuarioServicios;

    @GetMapping("/getUser")
    public List<Usuario> getAllUsuario(){
        return repositorio.findAll();
    }

    @GetMapping("/getUser/{identificacion}")
    public Usuario getUsuario(@PathVariable String identificacion){return usuarioServicios.obtenerPorIdentificacion(identificacion);}

    @DeleteMapping("/deleteUser/{identificacion}")
    public String delete(Usuario usuario){
        repositorio.delete(usuario);
        return "El usuario ha sido eliminado correctamente";
    }

    @PostMapping("/newUser")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(this.repositorio.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping(path = "/updateUser/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable int id, @RequestBody Usuario usuario){
        usuario.setId(id);
        return new ResponseEntity<Usuario>(usuarioServicios.update(usuario), HttpStatus.OK);
    }
}
