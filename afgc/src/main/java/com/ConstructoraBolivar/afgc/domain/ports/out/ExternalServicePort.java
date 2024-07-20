package com.ConstructoraBolivar.afgc.domain.ports.out;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.models.Location;

public interface ExternalServicePort {
    Character getCharacter(Long id);
    Episode getEpisode(Long id);
    Location getLocation(Long id);
}
