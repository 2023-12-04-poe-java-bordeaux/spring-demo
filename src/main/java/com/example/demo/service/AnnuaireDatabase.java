package com.example.demo.service;

import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnuaireDatabase {

    @Autowired
    private PersonneRepository personneRepository;

    public void add( Personne p){
       personneRepository.save(p);
    }

    public List<Personne> getAll(){
        return personneRepository.findAll();
    }

    public Optional<Personne> findById(Integer id){
       return personneRepository.findById(id);
    }

    public void delete(Integer id) {
       personneRepository.deleteById(id);
    }

    public void update(Integer id, Personne personne) {
        personneRepository.save(personne);
    }
}
