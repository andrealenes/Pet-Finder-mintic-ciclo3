package com.petfinder.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

public abstract class Converter <E,D> {

    public abstract E toEntity(D object);

    public abstract D toData(E object);

    public List<E> toEntity(List<D> list) {
        return list.stream()
            .map(object -> toEntity(object))
            .collect(Collectors.toList());
    }

    public List<D> toData(List<E> list) {
        return list.stream()
            .map(object -> toData(object))
            .collect(Collectors.toList());
    }
    
}
