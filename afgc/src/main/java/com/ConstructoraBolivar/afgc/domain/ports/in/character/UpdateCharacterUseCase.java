package com.ConstructoraBolivar.afgc.domain.ports.in.character;

import java.util.Optional;
import com.ConstructoraBolivar.afgc.domain.models.Character;

public interface UpdateCharacterUseCase {
    Optional<Character> updateCharacter(Long id, Character character);
}
