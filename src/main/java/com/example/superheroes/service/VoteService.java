package com.example.superheroes.service;

import com.example.superheroes.model.Hero;
import com.example.superheroes.model.Vote;
import com.example.superheroes.repository.HeroRepository;
import com.example.superheroes.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class VoteService {
    //Inyeccion de dependencias
    @Autowired
    private HeroRepository heroRepository;

    @Autowired
    private VoteRepository voteRepository;

    public Vote voteForHero(String superhero) {
        // Buscar el héroe por su nombre de superhéroe
        Hero hero = heroRepository.findBySuperhero(superhero)
                .orElseThrow(() -> new RuntimeException("Hero not found"));

        // Buscar el voto existente para el héroe
        Vote vote = voteRepository.findByHero(hero)
                .orElseGet(() -> {
                    // Crear un nuevo voto si no existe
                    Vote newVote = new Vote();
                    newVote.setHero(hero);
                    return newVote;
                });

        // Incrementar la cantidad de votos
        vote.setVotes(vote.getVotes() + 1);
        // Guardar o actualizar el voto en la base de datos
        return voteRepository.save(vote);
    }

    public List<Vote> getVotesOrderedByHero() {
        // Obtener la lista de votos ordenados por la cantidad de votos de mayor a menor
        return voteRepository.findAllByOrderByVotesDesc();
    }

    public List<Map<String, Object>> getVotesByPublisher() {
        // Obtener la cantidad de votos por publisher
        return voteRepository.countVotesByPublisher();
    }
}
