package com.ConstructoraBolivar.afgc.application.services;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.in.character.*;

import java.util.List;
import java.util.Optional;

public class CharacterService implements CreateCharacterUseCase, RetrieveCharacterUseCase, UpdateCharacterUseCase, DeleteCharacterUseCase, GetCharacterUseCase {

    private final CreateCharacterUseCase createCharacterUseCase;
    private final RetrieveCharacterUseCase retrieveCharacterUseCase;
    private final UpdateCharacterUseCase updateCharacterUseCase;
    private final DeleteCharacterUseCase deleteCharacterUseCase;
    private final GetCharacterUseCase getCharacterUseCase;

    public CharacterService(CreateCharacterUseCase createCharacterUseCase, RetrieveCharacterUseCase retrieveCharacterUseCase, UpdateCharacterUseCase updateCharacterUseCase, DeleteCharacterUseCase deleteCharacterUseCase, GetCharacterUseCase getCharacterUseCase) {
        this.createCharacterUseCase = createCharacterUseCase;
        this.retrieveCharacterUseCase = retrieveCharacterUseCase;
        this.updateCharacterUseCase = updateCharacterUseCase;
        this.deleteCharacterUseCase = deleteCharacterUseCase;
        this.getCharacterUseCase = getCharacterUseCase;
    }

    @Override
    public Character createCharacter(Character character) {
        return createCharacterUseCase.createCharacter(character);
    }

    @Override
    public boolean deleteCharacter(Long id) {
        return deleteCharacterUseCase.deleteCharacter(id);
    }

    @Override
    public Optional<Character> getCharacter(Long id) {
        return retrieveCharacterUseCase.getCharacter(id);
    }

    @Override
    public List<Character> getAllCharacters() {
        return retrieveCharacterUseCase.getAllCharacters();
    }

    @Override
    public Optional<Character> updateCharacter(Long id, Character character) {
        return updateCharacterUseCase.updateCharacter(id, character);
    }

    @Override
    public Optional<Character> getCharacterName(String name) {
        return getCharacterUseCase.getCharacterName(name);
    }
}
