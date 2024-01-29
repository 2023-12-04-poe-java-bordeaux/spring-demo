package com.example.demo;

import com.example.demo.model.Personne;
import com.example.demo.service.AnnuaireDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AnnuaireDatabase annuaireDatabase;

	@Test
	void testAnnuairePersonne() {

		Personne personne = new Personne("JC", "Dominguez");
		annuaireDatabase.add(personne);
	}

	@Test
	void testDelete(){
		annuaireDatabase.delete(1);
	}

	@Test
	void testFindById(){
		Optional<Personne> op = annuaireDatabase.findById(2);
		if(op.isEmpty())
			System.out.println("id non trouvé");
		else {
			Personne personnne = op.get();
			System.out.println(personnne);
		}

	}

	@Test
	void testUpdate(){
		Optional<Personne> op = annuaireDatabase.findById(2);
		if(op.isPresent()){
			Personne personne = op.get();
			personne.setPrenom("Jean-Christophe");
			annuaireDatabase.update(personne);
		}
	}

}
