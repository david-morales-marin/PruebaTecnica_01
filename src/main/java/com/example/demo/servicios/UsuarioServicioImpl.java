package com.example.demo.servicios;

import com.example.demo.modelo.Usuario;
import com.example.demo.repositorio.Repositorio;
import com.example.demo.util.RestIncorrecta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServicioImpl extends UsuarioServicios {
    private static final String NO_EXISTE_EL_USUARIO_QUE_DESEA_ACTUALIZAR = "NO existe el usuario que desea actualizar";
    @Autowired
    private Repositorio repositorio;
    @Override
    public Usuario obtenerPorIdentificacion(String identificacion){
        List<Usuario> usuarios = this.repositorio.findAll();
        for (Usuario usuario : usuarios){
            if (usuario.getIdentificacion().equals(identificacion)){
                return usuario;
            }
        }
        throw new RestIncorrecta(HttpStatus.NOT_FOUND.value(), NO_EXISTE_EL_USUARIO_QUE_DESEA_ACTUALIZAR);
    }
    @Override
    public Usuario update(Usuario usuarioActual) {

        Usuario usuarioTemp = null;
        List<Usuario> usuarios = this.repositorio.findAll();

        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificacion().equals(usuario.getIdentificacion())) {
                usuarioTemp = usuario;
                break;
            }
        }
        if (usuarioTemp == null){
            throw new RestIncorrecta(HttpStatus.NOT_FOUND.value(), NO_EXISTE_EL_USUARIO_QUE_DESEA_ACTUALIZAR);
        }

        usuarioTemp.setIdentificacion(usuarioActual.getIdentificacion());
        usuarioTemp.setTelefono(usuarioActual.getTelefono());
        usuarioTemp.setNombre(usuarioActual.getNombre());

        this.repositorio.save(usuarioTemp);
        return usuarioTemp;
    }
}
