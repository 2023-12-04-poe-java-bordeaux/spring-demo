package com.example.demo.dao;

import com.example.demo.model.Chien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChienRepository extends JpaRepository<Chien, Integer> {
}
