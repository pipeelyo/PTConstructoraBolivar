package com.ConstructoraBolivar.afgc.application.usecases.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.in.character.GetCharacterUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;

import java.util.Optional;

public class GetCharacterUseCasetmlp implements GetCharacterUseCase {

    private final CharacterRepositoryPort characterRepositoryPort;

    public GetCharacterUseCasetmlp(CharacterRepositoryPort characterRepositoryPort) {
        this.characterRepositoryPort = characterRepositoryPort;
    }


    @Override
    public Optional<Character> getCharacterName(String name) {
        return characterRepositoryPort.findByName(name);
    }
}
