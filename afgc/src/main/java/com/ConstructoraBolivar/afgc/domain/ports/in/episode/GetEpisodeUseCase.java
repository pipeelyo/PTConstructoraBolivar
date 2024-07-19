package com.ConstructoraBolivar.afgc.domain.ports.in.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;

import java.util.Optional;

public interface GetEpisodeUseCase {
    Optional<Episode> getEpisode(String name);
}
