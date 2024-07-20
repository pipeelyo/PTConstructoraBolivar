package com.ConstructoraBolivar.afgc.infrastructure.controllers;

import com.ConstructoraBolivar.afgc.application.services.EpisodeService;
import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.infrastructure.adapters.ExternalServiceAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/episode")
public class EpisodeController {

    private final EpisodeService episodeService;
    private final ExternalServiceAdapter externalServiceAdapter;

    public EpisodeController(EpisodeService episodeService, ExternalServiceAdapter externalServiceAdapter) {
        this.episodeService = episodeService;
        this.externalServiceAdapter = externalServiceAdapter;
    }

    @PostMapping
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode) {
        Episode created = episodeService.createEpisode(episode);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Episode> getCharacter(@PathVariable Long id) {
        return  episodeService.getEpisode(id)
                .map(episode -> new ResponseEntity<>( episode, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Episode>> getAllCharacters() {
        List<Episode> episode = episodeService.getEpisodes();
        return new ResponseEntity<>(episode, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Episode> updateCharacter(@PathVariable Long id, @RequestBody Episode episode){
        return  episodeService.updateEpisode(id, episode)
                .map(episode1 -> new ResponseEntity<>(episode1, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Episode> deleteCharacter(@PathVariable Long id) {
        if(episodeService.deleteEpisode(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/aditionalinfo")
    public ResponseEntity<Episode> getCharacterByAditionalInfo(@RequestParam Long id){
        Episode episode = externalServiceAdapter.getEpisode(id);
        return new ResponseEntity<>(episode, HttpStatus.OK);
    }


}
