package com.example.demo;

import com.example.demo.model.Personne;
import com.example.demo.service.AnnuaireDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	AnnuaireDatabase annuaireDatabase;

	@Test
	void testAnnuairePersonne() {

		Personne personne = new Personne("JC", "Dominguez");
		annuaireDatabase.add(personne);
	}

}
