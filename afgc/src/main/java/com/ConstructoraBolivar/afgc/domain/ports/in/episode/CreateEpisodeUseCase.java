package com.ConstructoraBolivar.afgc.domain.ports.in.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;

public interface CreateEpisodeUseCase {
    Episode createEpisode(Episode episode);
}
