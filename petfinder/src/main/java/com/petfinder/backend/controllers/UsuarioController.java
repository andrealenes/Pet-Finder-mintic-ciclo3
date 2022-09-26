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

import com.petfinder.backend.data.UsuarioData;
import com.petfinder.backend.services.UsuarioService;

@RestController
@RequestMapping(path="/api/usuarios")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    //Listar todas los Usuarios
    @GetMapping
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }

    //Listar un usuario (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        return new ResponseEntity<>(usuarioService.findById(id), HttpStatus.OK);
    }

    //Agregar un usuario
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UsuarioData role) {
        return new ResponseEntity<>(usuarioService.insert(role), HttpStatus.CREATED);
    }

    //Editar un usuario
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UsuarioData role) {
        return new ResponseEntity<>(usuarioService.update(role), HttpStatus.OK);
    }

    //Eliminar un usuario
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(usuarioService.deleteById(id), HttpStatus.OK);
    }

}
