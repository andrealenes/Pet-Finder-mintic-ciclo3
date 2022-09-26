package com.petfinder.backend.converters;

import com.petfinder.backend.data.UsuarioData;
import com.petfinder.backend.entities.Usuario;

public class UsuarioConverter extends Converter <Usuario, UsuarioData>{
    
    private RoleConverter roleConverter = new RoleConverter();
    
    @Override
    public Usuario toEntity(UsuarioData object) {
        return object == null ? null : Usuario.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .apellidos(object.getApellidos())
                .email(object.getEmail())
                .telefono(object.getTelefono())
                .contrasenha(object.getContrasenha())
                .roles(roleConverter.toEntity(object.getRoles()))
                .registration(object.getRegistration())
                .enable(object.isEnable())
                .build();
    }

    @Override
    public UsuarioData toData(Usuario object) {
        return object == null ? null : UsuarioData.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .apellidos(object.getApellidos())
                .email(object.getEmail())
                .telefono(object.getTelefono())
                .contrasenha(null)
                .roles(roleConverter.toData(object.getRoles()))
                .registration(object.getRegistration())
                .enable(object.isEnable())
                .build();
    }
    

}
