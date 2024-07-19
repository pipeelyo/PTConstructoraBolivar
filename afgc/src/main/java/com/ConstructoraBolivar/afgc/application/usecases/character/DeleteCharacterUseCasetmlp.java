package com.ConstructoraBolivar.afgc.application.usecases.character;

import com.ConstructoraBolivar.afgc.domain.ports.in.character.DeleteCharacterUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;

public class DeleteCharacterUseCasetmlp implements DeleteCharacterUseCase {

    private final CharacterRepositoryPort repository;

    public DeleteCharacterUseCasetmlp(CharacterRepositoryPort repository) {
        this.repository = repository;
    }

    @Override
    public boolean deleteCharacter(Long id) {
        return repository.deleteById(id);
    }
}
