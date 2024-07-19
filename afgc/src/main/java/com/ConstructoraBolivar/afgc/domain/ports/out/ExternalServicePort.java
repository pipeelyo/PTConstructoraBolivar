package com.ConstructoraBolivar.afgc.domain.ports.out;

import com.ConstructoraBolivar.afgc.domain.models.Character;

public interface ExternalServicePort {
    Character getCharacter(Long id);
}
