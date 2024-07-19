package com.ConstructoraBolivar.afgc.application.usecases.episode;

import com.ConstructoraBolivar.afgc.domain.ports.in.episode.DeleteEpisodeUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;

public class DeleteEpisodeUseCasetmlp implements DeleteEpisodeUseCase {
    private final EpisodeRepositoryPort episodeRepositoryPort;

    public DeleteEpisodeUseCasetmlp(EpisodeRepositoryPort episodeRepositoryPort) {
        this.episodeRepositoryPort = episodeRepositoryPort;
    }

    @Override
    public boolean deleteEpisode(Long id) {
        return episodeRepositoryPort.deleteById(id);
    }
}
