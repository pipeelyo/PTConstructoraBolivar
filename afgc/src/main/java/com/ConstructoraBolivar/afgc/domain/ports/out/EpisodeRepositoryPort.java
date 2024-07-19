package com.ConstructoraBolivar.afgc.domain.ports.out;

import com.ConstructoraBolivar.afgc.domain.models.Episode;

import java.util.List;
import java.util.Optional;

public interface EpisodeRepositoryPort {
    Episode save(Episode episode);
    Optional<Episode> findById(Long id);
    Optional<Episode> findByName(String name);
    List<Episode> findAll();
    Optional<Episode> update(Long id, Episode episode);
    boolean deleteById(Long id);
}
