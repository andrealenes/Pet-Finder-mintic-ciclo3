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
public class UsuarioData {
    
    private int id;
    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String contrasenha;
    private List<RoleData> roles;
    private Date registration;
    private boolean enable;
}
