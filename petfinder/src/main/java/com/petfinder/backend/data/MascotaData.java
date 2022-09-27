package com.petfinder.backend.data;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MascotaData {

    private int id;
    private String nombre;
    private String tipo;
    private String raza;
    private String sexo;
    private Date fecha_perdida;
    private String descripcion;
    private String foto;
    private List<UsuarioData> usuarios;

}
