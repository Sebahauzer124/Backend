/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.service;

import com.artilugios.Artilugios.model.Producto;
import java.util.List;



/**
 *
 * @author Usuario
 */
public interface IProductoService {
       public List<Producto> getProducto();
    public void saveProducto(Producto produc);
    public void deleteProducto(Long id);
    public Producto findProducto (Long id);
    
}
