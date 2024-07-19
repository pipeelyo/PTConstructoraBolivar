package com.ConstructoraBolivar.afgc.application.usecases.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.ports.in.episode.GetEpisodeUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;

import java.util.Optional;

public class GetEpisodeUseCasetmlp implements GetEpisodeUseCase {

    private final EpisodeRepositoryPort episodeRepositoryPort;

    public GetEpisodeUseCasetmlp(EpisodeRepositoryPort episodeRepositoryPort) {
        this.episodeRepositoryPort = episodeRepositoryPort;
    }

    @Override
    public Optional<Episode> getEpisode(String name) {
        return episodeRepositoryPort.findByName(name);
    }
}
