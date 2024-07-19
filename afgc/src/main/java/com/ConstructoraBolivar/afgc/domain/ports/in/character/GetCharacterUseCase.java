package com.ConstructoraBolivar.afgc.domain.ports.in.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;

import java.util.Optional;

public interface GetCharacterUseCase {
    Optional<Character> getCharacterName(String name);
}
