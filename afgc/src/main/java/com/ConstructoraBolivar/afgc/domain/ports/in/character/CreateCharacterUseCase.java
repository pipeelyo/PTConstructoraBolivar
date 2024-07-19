package com.ConstructoraBolivar.afgc.domain.ports.in.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;

public interface CreateCharacterUseCase {
    public Character createCharacter(Character character);
}
