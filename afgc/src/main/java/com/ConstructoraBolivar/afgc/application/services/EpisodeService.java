package com.ConstructoraBolivar.afgc.application.services;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.ports.in.episode.*;

import java.util.List;
import java.util.Optional;

public class EpisodeService implements CreateEpisodeUseCase, RetrieveEpisodeUseCase, UpdateEpisodeUseCase, DeleteEpisodeUseCase, GetEpisodeUseCase{

    private final CreateEpisodeUseCase createEpisodeUseCase;
    private final RetrieveEpisodeUseCase retrieveEpisodeUseCase;
    private final UpdateEpisodeUseCase updateEpisodeUseCase;
    private final DeleteEpisodeUseCase deleteEpisodeUseCase;
    private final GetEpisodeUseCase getEpisodeUseCase;

    public EpisodeService(CreateEpisodeUseCase createEpisodeUseCase, RetrieveEpisodeUseCase retrieveEpisodeUseCase, UpdateEpisodeUseCase updateEpisodeUseCase, DeleteEpisodeUseCase deleteEpisodeUseCase, GetEpisodeUseCase getEpisodeUseCase) {
        this.createEpisodeUseCase = createEpisodeUseCase;
        this.retrieveEpisodeUseCase = retrieveEpisodeUseCase;
        this.updateEpisodeUseCase = updateEpisodeUseCase;
        this.deleteEpisodeUseCase = deleteEpisodeUseCase;
        this.getEpisodeUseCase = getEpisodeUseCase;
    }

    @Override
    public Episode createEpisode(Episode episode) {
        return createEpisodeUseCase.createEpisode(episode);
    }

    @Override
    public boolean deleteEpisode(Long id) {
        return deleteEpisodeUseCase.deleteEpisode(id);
    }

    @Override
    public Optional<Episode> getEpisode(String name) {
        return getEpisodeUseCase.getEpisode(name);
    }

    @Override
    public Optional<Episode> getEpisode(Long id) {
        return retrieveEpisodeUseCase.getEpisode(id);
    }

    @Override
    public List<Episode> getEpisodes() {
        return retrieveEpisodeUseCase.getEpisodes();
    }

    @Override
    public Optional<Episode> updateEpisode(Long id, Episode episode) {
        return updateEpisodeUseCase.updateEpisode(id, episode);
    }
}
