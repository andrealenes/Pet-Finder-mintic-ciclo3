package com.petfinder.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.petfinder.backend.converters.UsuarioConverter;
import com.petfinder.backend.data.UsuarioData;
import com.petfinder.backend.entities.Usuario;
import com.petfinder.backend.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioConverter usuarioConverter = new UsuarioConverter();

    // Insertar un Usuario
    public UsuarioData insert(UsuarioData usuario){
        if(usuarioRepository.existsById(usuario.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡Usuario ya existe!");
        return usuarioConverter.toData(usuarioRepository.save(usuarioConverter.toEntity(usuario)));
    }

    // Listar usuario (por id)
    public UsuarioData findById(int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡El rol no existe!");
        return usuarioConverter.toData(usuario.get());
    }

    // Consultar todos los usuarios
    public List<UsuarioData> findAll(){
        return usuarioConverter.toData(usuarioRepository.findAll());
    }

    // Actualizar usuario
    public UsuarioData update(UsuarioData usuario){
        if(!usuarioRepository.existsById(usuario.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Usuario no existe!");
        return usuarioConverter.toData(usuarioRepository.save(usuarioConverter.toEntity(usuario)));
    }

    // Eliminar un usuario (por id)
    public UsuarioData deleteById(int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if(usuario.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Usuario no existe!");
        UsuarioData usuarioData = usuarioConverter.toData(usuario.get());
        usuarioRepository.deleteById(id);
        return usuarioData;
    }
}
