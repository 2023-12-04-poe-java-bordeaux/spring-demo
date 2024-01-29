package com.example.demo.controller;

import com.example.demo.model.Personne;

// outils à tester ? MapStruct, modelmapper
public class PersonneMapper {

    public static PersonneDTO convertEntityToDto(Personne entity){
        PersonneDTO dto = new PersonneDTO();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getPrenom());
        dto.setLastName(entity.getNom());
        return dto;
    }

    public static Personne convertDtoToEntity(PersonneDTO dto){
        Personne entity = new Personne();
        entity.setId(dto.getId());
        entity.setPrenom(dto.getFirstName());
        entity.setNom(dto.getLastName());
        return entity;
    }
}
