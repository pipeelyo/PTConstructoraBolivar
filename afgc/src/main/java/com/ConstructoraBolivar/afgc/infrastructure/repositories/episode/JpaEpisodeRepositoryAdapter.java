package com.ConstructoraBolivar.afgc.infrastructure.repositories.episode;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;
import com.ConstructoraBolivar.afgc.infrastructure.entities.EpisodeEntity;
import com.ConstructoraBolivar.afgc.infrastructure.entities.LocationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaEpisodeRepositoryAdapter implements EpisodeRepositoryPort {

    private final JpaEpisodeRepository jpaEpisodeRepository;

    public JpaEpisodeRepositoryAdapter(JpaEpisodeRepository jpaEpisodeRepository) {
        this.jpaEpisodeRepository = jpaEpisodeRepository;
    }

    @Override
    public Episode save(Episode episode) {
        EpisodeEntity episodeEntity = EpisodeEntity.fromEntityModel(episode);
        EpisodeEntity savedEpisodeEntitry = jpaEpisodeRepository.save(episodeEntity);
        return savedEpisodeEntitry.toDomainModel();
    }

    @Override
    public Optional<Episode> findById(Long id) {
        return jpaEpisodeRepository.findById(id).map(EpisodeEntity::toDomainModel);
    }

    @Override
    public Optional<Episode> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Episode> findAll() {
        return jpaEpisodeRepository.findAll().stream()
                .map(EpisodeEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Episode> update(Long id, Episode episode) {
        if(jpaEpisodeRepository.existsById(id)){
            EpisodeEntity episodeEntity = EpisodeEntity.fromEntityModel(episode);
            EpisodeEntity updateEpisodeEntity = jpaEpisodeRepository.save(episodeEntity);
            return Optional.of(updateEpisodeEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaEpisodeRepository.existsById(id)){
            jpaEpisodeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
