package com.ConstructoraBolivar.afgc.application.usecases.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.ports.in.episode.CreateEpisodeUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;

public class CreateEpisodeUseCasetmlp implements CreateEpisodeUseCase {

    private final EpisodeRepositoryPort episodeRepositoryPort;

    public CreateEpisodeUseCasetmlp(EpisodeRepositoryPort episodeRepositoryPort) {
        this.episodeRepositoryPort = episodeRepositoryPort;
    }

    @Override
    public Episode createEpisode(Episode episode) {
        return episodeRepositoryPort.save(episode);
    }
}
