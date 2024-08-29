package com.example.superheroes.controller;

import com.example.superheroes.model.Vote;
import com.example.superheroes.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public ResponseEntity<Vote> vote(@RequestBody Map<String, String> body) {
        String superhero = body.get("superhero");
        Vote vote = voteService.voteForHero(superhero);
        return ResponseEntity.ok(vote);
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Vote>> getVotesOrderedByHero() {
        List<Vote> votes = voteService.getVotesOrderedByHero();
        return ResponseEntity.ok(votes);
    }

    @GetMapping("/publisher")
    public ResponseEntity<List<Map<String, Object>>> getVotesByPublisher() {
        List<Map<String, Object>> votes = voteService.getVotesByPublisher();
        return ResponseEntity.ok(votes);
    }
}
