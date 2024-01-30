package com.example.demo;

import com.example.demo.dao.AdresseRepository;
import com.example.demo.dao.ChienRepository;
import com.example.demo.dao.PersonneRepository;
import com.example.demo.dao.StageRepository;
import com.example.demo.model.Adresse;
import com.example.demo.model.Chien;
import com.example.demo.model.Personne;
import com.example.demo.model.Stage;
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
	@Autowired
	StageRepository stageRepository;
	@Autowired
	ChienRepository chienRepository;

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

	@Test
	void testManyToMany(){
		Personne alain = new Personne("Alain", "Dupond");
		personneRepository.save(alain);
		Personne marie = new Personne("Marie", "Durand");
		personneRepository.save(marie);
		Personne said = new Personne("Said", "Dupond");
		personneRepository.save(said);

		Stage stageJava = new Stage("Java", "pour débutants");
		stageJava.addStagiaire(alain);
		stageJava.addStagiaire(marie);
		stageRepository.save(stageJava);

		Stage stageSQL = new Stage("SQL", "pour administrateurs");
		stageSQL.addStagiaire(marie);
		stageSQL.addStagiaire(said);
		stageRepository.save(stageSQL);
	}

	@Test
	void testOneToMany(){
		Chien medor = new Chien("Medor");
		chienRepository.save(medor);

		Chien rocky = new Chien("Rocky");
		chienRepository.save(rocky);

		Personne alain = new Personne("Alain", "Dupond");
		alain.addChien(medor);
		alain.addChien(rocky);
		personneRepository.save(alain);
	}

	@Test
	void testLectureChiens(){
		Optional<Personne> optional = personneRepository.findById(9);
		if(optional.isPresent()){
			Personne alain = optional.get();
			alain.getChiens().forEach(chien -> System.out.println(chien.getNom()));
		}
	}
}
