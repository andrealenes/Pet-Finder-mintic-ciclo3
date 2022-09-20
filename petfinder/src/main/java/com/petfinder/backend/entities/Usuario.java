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
import lombok.AccessLevel;
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
public class Usuario {
    
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String apellidos;
    
    @Column(nullable = false, unique = true)
    private String email;
    
    @Column(nullable = false, unique = true)
    private String telefono;
    
    @Getter(value = AccessLevel.NONE)
    @Column(nullable = false)
    private String contrasenha;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private List<Role> roles;
    
    @Column(nullable = false)
    private Date registration;
    
    @Column(nullable = false)
    private boolean enable;
    
    public boolean checkPassword(String contrasenha){
        return this.contrasenha.equals(contrasenha);
    }
}
