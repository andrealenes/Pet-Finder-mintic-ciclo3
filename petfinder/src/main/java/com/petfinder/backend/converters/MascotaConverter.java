package com.petfinder.backend.converters;
package com.petfinder.backend.entities.Mascota;
package com.petfinder.backend.data.MascotaData;

import org.springframework.data.annotation.AccessType;

public class MascotaConverter extends Converter <Mascota, MascotaData>{
 
    @override
    public Mascota toEntity(MascotaData object){
        return Mascota.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .tipo(object.getTipo())
                .raza(object.get.Raza())
                .sexo(object.getSexo())
                .fecha_perdida(object.getFecha())
                .descripcion(object.getDescripcion())
                .foto(object.getFoto())
                .propietarios(object.getPropietarios())
                .build()            
    }

    @override
    public MascotaData toData(Mascota object){
        return MascotaData.builder()
                .id(object.getId())
                .nombre(object.getNombre())
                .tipo(object.getTipo())
                .raza(object.get.Raza())
                .sexo(object.getSexo())
                .fecha_perdida(object.getFecha())
                .descripcion(object.getDescripcion())
                .foto(object.getFoto())
                .propietarios(object.getPropietarios())
                .build()            
    }


}
