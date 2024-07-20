package com.ConstructoraBolivar.afgc.infrastructure.controllers;


import com.ConstructoraBolivar.afgc.application.services.CharacterService;
import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.infrastructure.adapters.ExternalServiceAdapter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/character")
public class CharacterController {
    private final CharacterService characterService;
    private final ExternalServiceAdapter externalServiceAdapter;

    public CharacterController(CharacterService characterService, ExternalServiceAdapter externalServiceAdapter) {
        this.characterService = characterService;
        this.externalServiceAdapter = externalServiceAdapter;
    }

    @PostMapping
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        Character created = characterService.createCharacter(character);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Character> getCharacter(@PathVariable Long id) {
        return  characterService.getCharacter(id)
                .map(character -> new ResponseEntity<>( character, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Character>> getAllCharacters() {
        List<Character> characters = characterService.getAllCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character){
         return  characterService.updateCharacter(id, character)
                 .map(character1 -> new ResponseEntity<>(character1, HttpStatus.OK))
                 .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Character> deleteCharacter(@PathVariable Long id) {
        if(characterService.deleteCharacter(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/aditionalinfo")
    public ResponseEntity<Character> getCharacterByAditionalInfo(@RequestParam Long id){
        Character character = externalServiceAdapter.getCharacter(id);
        return new ResponseEntity<>(character, HttpStatus.OK);
    }

}
