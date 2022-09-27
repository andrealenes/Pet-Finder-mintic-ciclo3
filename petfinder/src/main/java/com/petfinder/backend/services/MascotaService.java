package com.petfinder.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.petfinder.backend.converters.MascotaConverter;
import com.petfinder.backend.data.MascotaData;
import com.petfinder.backend.entities.Mascota;
import com.petfinder.backend.repositories.MascotaRepository;


@Service
public class MascotaService {

    @Autowired
    private MascotaRepository mascotaRepository;

    private MascotaConverter mascotaConverter = new MascotaConverter();

    // Insertar una mascota
    public MascotaData insert(MascotaData mascota){
        if(mascotaRepository.existsById(mascota.getId()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "¡Mascota ya existe!");
        return mascotaConverter.toData(mascotaRepository.save(mascotaConverter.toEntity(mascota)));
    }

    // Listar mascota (por id)
    public MascotaData findById(int id){
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        if(mascota.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡La Mascota no existe!");
        return mascotaConverter.toData(mascota.get());
    }

    // Consultar todos los mascota
    public List<MascotaData> findAll(){
        return mascotaConverter.toData(mascotaRepository.findAll());
    }

    // Actualizar mascota
    public MascotaData update(MascotaData mascota){
        if(!mascotaRepository.existsById(mascota.getId()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Mascota no existe!");
        return mascotaConverter.toData(mascotaRepository.save(mascotaConverter.toEntity(mascota)));
    }

    // Eliminar una mascota (por id)
    public MascotaData deleteById(int id){
        Optional<Mascota> mascota = mascotaRepository.findById(id);
        if(mascota.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "¡Mascota no existe!");
        MascotaData mascotaData = mascotaConverter.toData(mascota.get());
        mascotaRepository.deleteById(id);
        return mascotaData;
    }

}
