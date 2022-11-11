/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombre", nullable = false, updatable = true)
    private String nombre;
    @Column(name = "apellido", nullable = false, updatable = true)
    private String apellido;
    @Column(name = "dni", nullable = false, updatable = true)
    private String dni;
    @Column(name = "direccion", nullable = false, updatable = true)
    private String direccion;
    @Column(name = "nacionalidad", nullable = false, updatable = true)
    private String nacionalidad;
    @Column(name = "provincia", nullable = false, updatable = true)
    private String provincia;
    @Column(name = "localidad", nullable = false, updatable = true)
    private String localidad;
    
    @JsonBackReference
    @OneToMany(mappedBy = "persona")
    private List<Producto> producto;
    
public Persona(){};

    public Persona(Long id, String nombre, String apellido, String dni, String direccion, String nacionalidad, String provincia, String localidad, List<Producto> producto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
        this.nacionalidad = nacionalidad;
        this.provincia = provincia;
        this.localidad = localidad;
        this.producto = producto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Producto> getProducto() {
        return producto;
    }

    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }

  

  
       
 



}



    