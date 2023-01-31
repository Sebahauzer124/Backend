/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artilugios.Artilugios.Controller;

import com.artilugios.Artilugios.model.Persona;
import com.artilugios.Artilugios.service.IPersonaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersonas(){
        return interPersona.getPersonas();
   }    
@GetMapping("/personas/traer/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
       Persona persona= interPersona.findPersona(id);
        return new ResponseEntity(persona, HttpStatus.OK);
    }

    
    @PostMapping("/personas/crear")
    public ResponseEntity<Persona> createPersona (@RequestBody Persona perso){
    interPersona.savePersona(perso);
    return new ResponseEntity<>(perso,HttpStatus.CREATED);
    }

    @DeleteMapping("/personas/borrar/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable ("id") Long id){
    interPersona.deletePersona(id);
    return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping("/personas/editar/{id}")
      public ResponseEntity<?> editarPersona(@PathVariable ("id") Long id,
                                    @RequestBody Persona persona){
    Persona perso=interPersona.findPersona(id);
    
   perso.setNombre(persona.getNombre());
   perso.setApellido(persona.getApellido());
   perso.setDni(persona.getDni());
   perso.setDireccion(persona.getDireccion());
   perso.setNacionalidad(persona.getNacionalidad());
   perso.setProvincia(persona.getProvincia());
   perso.setLocalidad(persona.getLocalidad());
   interPersona.savePersona(perso);
   return new ResponseEntity(perso,HttpStatus.OK);
                               
    }
}