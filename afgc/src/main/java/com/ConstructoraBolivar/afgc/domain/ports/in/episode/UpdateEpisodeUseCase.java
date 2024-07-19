package com.ConstructoraBolivar.afgc.domain.ports.in.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;

import java.util.Optional;

public interface UpdateEpisodeUseCase {
    Optional<Episode> updateEpisode(Long id, Episode episode);
}
