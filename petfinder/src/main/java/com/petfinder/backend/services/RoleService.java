package com.petfinder.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.petfinder.backend.converters.RoleConverter;
import com.petfinder.backend.data.RoleData;
import com.petfinder.backend.entities.Role;
import com.petfinder.backend.repositories.RoleRepository;

@Service
public class RoleService {
    
    @Autowired
    private RoleRepository roleRepository;

    private RoleConverter roleConverter = new RoleConverter();

    //Listar todos los roles
    public List<RoleData> findAll(){
        return roleConverter.toData(roleRepository.findAll());
    }

    //Listar role (por id)
    public RoleData findById(int id){
        Optional<Role> role = roleRepository.findById(id);
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El role no existe");
        return roleConverter.toData(role.get());
    }

    //Agregar un role
    public RoleData insert(RoleData role){
        if(roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡El rol ya existe!");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    // Editar un role
    public RoleData update(RoleData role){
        if(!roleRepository.existsById(role.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El rol no existe!");
        return roleConverter.toData(roleRepository.save(roleConverter.toEntity(role)));
    }

    // Eliminar un role(por id)
    public RoleData deleteById(int id){
        Optional<Role> role = roleRepository.findById(id);
        if(role.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El rol no existe!");
        RoleData rolData = roleConverter.toData(role.get());
        roleRepository.deleteById(id);
        return rolData;
    }
}
