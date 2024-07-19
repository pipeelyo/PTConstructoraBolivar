package com.ConstructoraBolivar.afgc.application.usecases.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.in.character.RetrieveCharacterUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveCharacterUseCasetmlp implements RetrieveCharacterUseCase {

    private final CharacterRepositoryPort characterRepositoryPort;

    public RetrieveCharacterUseCasetmlp(CharacterRepositoryPort characterRepositoryPort) {
        this.characterRepositoryPort = characterRepositoryPort;
    }

    @Override
    public Optional<Character> getCharacter(Long id) {
        return characterRepositoryPort.findById(id);
    }

    @Override
    public List<Character> getAllCharacters() {
        return characterRepositoryPort.findAll();
    }
}
