package com.ConstructoraBolivar.afgc.application.usecases.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.ports.in.episode.UpdateEpisodeUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;

import java.util.Optional;

public class UpdateEpisodeUseCasetmlp implements UpdateEpisodeUseCase {
    private final EpisodeRepositoryPort episodeRepositoryPort;

    public UpdateEpisodeUseCasetmlp(EpisodeRepositoryPort episodeRepositoryPort) {
        this.episodeRepositoryPort = episodeRepositoryPort;
    }

    @Override
    public Optional<Episode> updateEpisode(Long id, Episode episode) {
        return episodeRepositoryPort.update(id, episode);
    }
}
