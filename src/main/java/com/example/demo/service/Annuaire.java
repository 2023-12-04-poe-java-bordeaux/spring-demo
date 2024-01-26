package com.example.demo.service;

import com.example.demo.model.Personne;

import java.util.HashMap;
import java.util.List;

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

    public Personne findById(Integer id){
        return personnes.get(id);
    }
}
