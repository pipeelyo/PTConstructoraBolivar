package com.ConstructoraBolivar.afgc.domain.ports.in.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;

import java.util.List;
import java.util.Optional;

public interface RetrieveEpisodeUseCase {
    Optional<Episode> getEpisode(Long id);
    List<Episode> getEpisodes();
}
