/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.service;

import com.artilugios.Artilugios.model.Producto;
import com.artilugios.Artilugios.repository.ProductoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author Usuario
 */
@Service
public class ProductoService implements IProductoService {
    @Autowired
    private ProductoRepository producRepository;

    @Override
    public List<Producto> getProducto() {
       List<Producto> listaProductos= producRepository.findAll();
    return listaProductos;
    }

    @Override
    public void saveProducto(Producto produc) {
        producRepository.save(produc);
    }

    @Override
    public void deleteProducto(Long id) {
        producRepository.deleteById(id);
    }

    @Override
    public Producto findProducto(Long id) {
        Producto produc= producRepository.findById(id).orElse(null);
    return produc;
    }

 

  
    }
