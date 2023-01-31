/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class Orden {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;
    private Date fechaCreacion;
    private Date fechaRecibida;
    private double total;

    
    @ManyToOne
	private Persona persona;
	
	@OneToMany(mappedBy = "orden")
	private List<DetalleOrden> detalle;
    public Orden(Long id, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
        this.id = id;
        this.numero = numero;
        this.fechaCreacion = fechaCreacion;
        this.fechaRecibida = fechaRecibida;
        this.total = total;
    }
    
    
}
