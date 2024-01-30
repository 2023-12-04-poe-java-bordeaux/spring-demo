package com.example.demo;

import com.example.demo.dao.PersonneRepository;
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

	@Test
	void testFindByNom(){
		personneRepository.findAllByNom("Bond").forEach(System.out::println);
	}

}
