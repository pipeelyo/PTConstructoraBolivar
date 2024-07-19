package com.ConstructoraBolivar.afgc.application.usecases.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.in.character.CreateCharacterUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;

public class CreateCharacterUseCaseTmlp implements CreateCharacterUseCase {

    private final CharacterRepositoryPort repository;

    public CreateCharacterUseCaseTmlp(CharacterRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public Character createCharacter(Character character) {
        return repository.save(character);
    }
}
