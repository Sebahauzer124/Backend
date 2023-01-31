/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.Controller;

import com.artilugios.Artilugios.model.Producto;
import com.artilugios.Artilugios.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController {
    @Autowired
    private IProductoService interProducto;
    
    @GetMapping("/productos/traer")
    public List<Producto> getProducto(){
        return interProducto.getProducto();
   }    
@GetMapping("/productos/traer/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") Long id) {
       Producto producto= interProducto.findProducto(id);
        return new ResponseEntity(producto, HttpStatus.OK);
    }


    @PostMapping("/productos/crear")
    public ResponseEntity<Producto> createProducto (@RequestBody Producto produc){
    interProducto.saveProducto(produc);
    return new ResponseEntity<>(produc,HttpStatus.CREATED);
    }
    
    @DeleteMapping("/productos/borrar/{id}")
    public ResponseEntity<?> deleteProducto(@PathVariable ("id") Long id){
    interProducto.deleteProducto(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/productos/editar/{id}")
      public ResponseEntity<?> editarProducto(@PathVariable ("id") Long id,
                                    @RequestBody Producto producto){
    Producto produc=interProducto.findProducto(id);
    
   produc.setNombre(producto.getNombre());
   produc.setDescripcion(producto.getDescripcion());
   produc.setImagen(producto.getImagen());
   produc.setPrecio(producto.getPrecio());
   produc.setCantidad(producto.getCantidad());
   
   
   interProducto.saveProducto(produc);
   return new ResponseEntity(produc,HttpStatus.OK);
                               
    }
}
