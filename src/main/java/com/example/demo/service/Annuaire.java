package com.example.demo.service;

import com.example.demo.model.Personne;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class Annuaire {

    private int idCount;
    private HashMap<Integer, Personne> personnes = new HashMap<Integer, Personne>();

    public void add( Personne p){
        idCount++;
        p.setId(idCount);
        personnes.put(idCount, p);
    }

    public List<Personne> getAll(){
        return personnes.values().stream().toList();
    }

    public Optional<Personne> findById(Integer id){
        Personne personne = personnes.get(id);
        if(personne == null)
            return Optional.empty();
        else
            return Optional.of(personne);
    }

    public void delete(Integer id) {
        personnes.remove(id);
    }

    public void update(Integer id, Personne personne) {
        personnes.put(id, personne);
    }
}
