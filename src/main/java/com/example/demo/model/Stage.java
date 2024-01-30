package com.example.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;
    private String description;

    @ManyToMany
    private List<Personne> stagiaires = new ArrayList<>();

    public Stage() {
    }

    public Stage(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Personne> getStagiaires() {
        return stagiaires;
    }

    public void setStagiaires(List<Personne> stagiaires) {
        this.stagiaires = stagiaires;
    }

    public void addStagiaire(Personne p){
        stagiaires.add(p);
    }
}
