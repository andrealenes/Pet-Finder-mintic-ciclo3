package com.petfinder.backend.converters;

import com.petfinder.backend.data.MascotaData;
import com.petfinder.backend.entities.Mascota;

public class MascotaConverter extends Converter <Mascota, MascotaData>{
    
    private UsuarioConverter usuarioConverter = new UsuarioConverter();
    
    @Override
    public Mascota toEntity(MascotaData object) {
        return object == null ? null : Mascota.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .tipo(object.getTipo())
                .raza(object.getRaza())
                .sexo(object.getSexo())
                .fecha_perdida(object.getFecha_perdida())
                .descripcion(object.getDescripcion())
                .foto(object.getFoto())
                .usuarios(usuarioConverter.toEntity(object.getUsuarios()))
                .build();
    }

    @Override
    public MascotaData toData(Mascota object) {
        return object == null ? null : MascotaData.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .tipo(object.getTipo())
                .raza(object.getRaza())
                .sexo(object.getSexo())
                .fecha_perdida(object.getFecha_perdida())
                .descripcion(object.getDescripcion())
                .foto(object.getFoto())
                .usuarios(usuarioConverter.toData(object.getUsuarios()))
                .build();
    }    
}
