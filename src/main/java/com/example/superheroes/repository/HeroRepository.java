package com.example.superheroes.repository;

import com.example.superheroes.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HeroRepository extends JpaRepository<Hero, Long> {
    Optional<Hero> findBySuperhero(String superhero);
}
