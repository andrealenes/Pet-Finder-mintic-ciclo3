package com.petfinder.backend.converters;
package com.petfinder.backend.entities.Usuario;
package com.petfinder.backend.data.UsuarioData;

public class UsuarioConverter extends Converter <Usuario, UsuarioData>{
    @override
    public Usuario toEntity(UsuarioData object){
        return object==null ? null : Usuario.builder()
            .id(object.getId())
            .nombre(object.getNombre())
            .apellidos(object.getApellidos())
            .email(object.getEmail())
            .telefono(object.getTelefono())
            .contrasenha(object.getContrasenha())
            .roles(object.getRoles()) /*  revisar */
            .registration(object.getRegistration())
            .enable(object.getEnable())
            .build(
    }

    @override
    public UsuarioData toEntity(Usuario object){
        return object==null ? null : UsuarioData.builder()
            .id(object.getId())
            .nombre(object.getNombre())
            .apellidos(object.getApellidos())
            .email(object.getEmail())
            .telefono(object.getTelefono())
            .contrasenha(object.getContrasenha())
            .roles(object.getRoles()) /*  revisar */
            .registration(object.getRegistration())
            .enable(object.getEnable())
            .build(
    }

}
