/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter @Setter
@Entity
public class Persona implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String apellido;

}
    