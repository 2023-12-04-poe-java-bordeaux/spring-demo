package com.example.demo.controller;

import com.example.demo.model.Personne;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class PersonneController {

    // GET /personnes
    @GetMapping("personnes")
    public List<Personne> getPersonnes(){
        ArrayList<Personne> personnes = new ArrayList<>();
        personnes.add(new Personne("JC", "Dominguez"));
        personnes.add(new Personne("Marie", "Dupont"));
        return personnes;
    }
}
