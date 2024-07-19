package com.ConstructoraBolivar.afgc.application.usecases.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.ports.in.episode.RetrieveEpisodeUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveEpisodeUseCasetmlp implements RetrieveEpisodeUseCase {
    private final EpisodeRepositoryPort episodeRepositoryPort;

    public RetrieveEpisodeUseCasetmlp(EpisodeRepositoryPort episodeRepositoryPort) {
        this.episodeRepositoryPort = episodeRepositoryPort;
    }

    @Override
    public Optional<Episode> getEpisode(Long id) {
        return episodeRepositoryPort.findById(id);
    }

    @Override
    public List<Episode> getEpisodes() {
        return episodeRepositoryPort.findAll();
    }
}
