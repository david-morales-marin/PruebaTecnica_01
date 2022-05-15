package com.example.demo.repositorio;

import com.example.demo.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface Repositorio extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT * FROM registro",nativeQuery = true)

    public List<Usuario> consultar();
    public Usuario save(Usuario usuario);
}
