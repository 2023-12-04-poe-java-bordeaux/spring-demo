package com.example.demo;

import com.example.demo.dao.AdresseRepository;
import com.example.demo.dao.PersonneRepository;
import com.example.demo.model.Adresse;
import com.example.demo.model.Personne;
import com.example.demo.service.AnnuaireDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class JpaRepositoryTests {

	@Autowired
	PersonneRepository personneRepository;
	@Autowired
	AdresseRepository adresseRepository;

	@Test
	void testFindByNom(){
		personneRepository.findAllByNom("Bond").forEach(System.out::println);
	}

	@Test
	void testManyToOne(){
		Adresse adresse = new Adresse("rue de la Mairie", 12, "Paris");
		adresseRepository.save(adresse);

		Personne alain = new Personne("Alain", "Dupond");
		alain.setAdresse(adresse);
		personneRepository.save(alain);
	}
}
