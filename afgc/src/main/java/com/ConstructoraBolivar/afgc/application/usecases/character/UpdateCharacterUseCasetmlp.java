package com.ConstructoraBolivar.afgc.application.usecases.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.in.character.UpdateCharacterUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;

import java.util.Optional;

public class UpdateCharacterUseCasetmlp implements UpdateCharacterUseCase {

    private final CharacterRepositoryPort characterRepositoryPort;

    public UpdateCharacterUseCasetmlp(CharacterRepositoryPort characterRepositoryPort) {
        this.characterRepositoryPort = characterRepositoryPort;
    }

    @Override
    public Optional<Character> updateCharacter(Long id, Character character) {
        return characterRepositoryPort.update(id, character);
    }
}
