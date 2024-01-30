package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="personnes")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String prenom;
    private String nom;

    @ManyToOne
    private Adresse adresse;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Chien> chiens = new ArrayList<>();

    public Personne() {
    }

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Chien> getChiens() {
        return chiens;
    }

    public void setChiens(List<Chien> chiens) {
        this.chiens = chiens;
    }

    public void addChien(Chien chien){
        chiens.add(chien);
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                '}';
    }
}
