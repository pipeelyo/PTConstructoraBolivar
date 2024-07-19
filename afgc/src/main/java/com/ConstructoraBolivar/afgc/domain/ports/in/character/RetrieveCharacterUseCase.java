package com.ConstructoraBolivar.afgc.domain.ports.in.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;

import java.util.List;
import java.util.Optional;

public interface RetrieveCharacterUseCase {
    Optional<Character> getCharacter(Long id);
    List<Character> getAllCharacters();
}
