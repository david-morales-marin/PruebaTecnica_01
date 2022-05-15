package com.example.demo.modelo;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final Integer serialVersionUID = 432;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "identificacion", length = 30)
    private String identificacion;
    @Column(name="telefono", length = 30)
    private String telefono;
    @Column(name="nombre", length = 30)
    private String nombre;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String  identificacion) {
        this.identificacion = identificacion;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Usuario(){

    }
    public Usuario(String identificacion, String telefono, String nombre){
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.nombre = nombre;
    }
}
