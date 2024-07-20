package com.ConstructoraBolivar.afgc.infrastructure.repositories.episode;

import com.ConstructoraBolivar.afgc.infrastructure.entities.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaEpisodeRepository extends JpaRepository<EpisodeEntity, Long> {
}
