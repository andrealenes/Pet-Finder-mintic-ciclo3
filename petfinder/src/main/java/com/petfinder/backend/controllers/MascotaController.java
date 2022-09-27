package com.petfinder.backend.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.petfinder.backend.data.MascotaData;
import com.petfinder.backend.services.MascotaService;

@RestController
@RequestMapping(path="/api/mascotas")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class MascotaController {
    
    @Autowired
    private MascotaService mascotaService;

    // Listar todas las mascotas
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(mascotaService.findAll(), HttpStatus.OK);
    }

    // Listar una mascota (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(mascotaService.findById(id), HttpStatus.OK);
    }

    // Agregar una mascota
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody MascotaData mascota){
        return new ResponseEntity<>(mascotaService.insert(mascota), HttpStatus.CREATED);
    }

    // Editar una mascota
    @PutMapping
    public ResponseEntity<?> update(@RequestBody MascotaData mascota){
        return new ResponseEntity<>(mascotaService.update(mascota), HttpStatus.OK);
    }

    // Eliminar una mascota
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(mascotaService.deleteById(id), HttpStatus.OK);
    }
}
