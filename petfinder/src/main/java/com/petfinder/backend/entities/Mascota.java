package com.petfinder.backend.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mascota {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String tipo;
    
    @Column(nullable = false)
    private String raza;
    
    @Column(nullable = false)
    private String sexo;
    
    @Column(nullable = false)
    private Date fecha_perdida;
    
    @Column(nullable = false)
    private String descripcion;
    
    @Column(nullable = false)
    private String foto;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)   
    private List<Usuario> usuarios;
    
}
