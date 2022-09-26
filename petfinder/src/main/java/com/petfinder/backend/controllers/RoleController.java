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

import com.petfinder.backend.data.RoleData;
import com.petfinder.backend.services.RoleService;

@RestController
@RequestMapping(path = "/api/roles")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class RoleController {

    @Autowired
    private RoleService roleService;

    //Listar todas los roles
    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    // Listar un rol (por id)
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    // Agregar un rol
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleData role){
        return new ResponseEntity<>(roleService.insert(role), HttpStatus.CREATED);
    }

    // Editar un rol
    @PutMapping
    public ResponseEntity<?> update(@RequestBody RoleData role){
        return new ResponseEntity<>(roleService.update(role), HttpStatus.OK);
    }

    // Eliminar un rol
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable int id){
        return new ResponseEntity<>(roleService.deleteById(id), HttpStatus.OK);
    }
    
}
