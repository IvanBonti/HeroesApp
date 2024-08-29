package com.example.superheroes.repository;

import com.example.superheroes.model.Hero;
import com.example.superheroes.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    // Encuentra un voto específico para un héroe
    Optional<Vote> findByHero(Hero hero);

    // Lista todos los votos ordenados por la cantidad de votos en orden descendente
    List<Vote> findAllByOrderByVotesDesc();

    // Lista la cantidad de votos por publisher
    @Query("SELECT v.hero.publisher AS publisher, SUM(v.votes) AS votes FROM Vote v GROUP BY v.hero.publisher")
    List<Map<String, Object>> countVotesByPublisher();
}
