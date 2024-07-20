package com.ConstructoraBolivar.afgc.infrastructure.repositories.Location;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.UpdateLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;
import com.ConstructoraBolivar.afgc.infrastructure.entities.LocationEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaLocationRepositoryAdapter implements LocationRepositoryPort {
    private final JpaLocationRepository jpaLocationRepository;

    public JpaLocationRepositoryAdapter(JpaLocationRepository jpaLocationRepository) {
        this.jpaLocationRepository = jpaLocationRepository;
    }

    @Override
    public Location save(Location location) {
        LocationEntity locationEntity = LocationEntity.fromLocationModel(location);
        LocationEntity savedLocationEntity = jpaLocationRepository.save(locationEntity);
        return savedLocationEntity.toDomainModel();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return jpaLocationRepository.findById(id).map(LocationEntity::toDomainModel);
    }

    @Override
    public Optional<Location> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Location> findAll() {
        return jpaLocationRepository.findAll().stream()
                .map(LocationEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Location> update(Long id, Location location) {
        if (jpaLocationRepository.existsById(id)) {
            LocationEntity locationEntity = LocationEntity.fromLocationModel(location);
            LocationEntity updatelocationEntity = jpaLocationRepository.save(locationEntity);
            return Optional.of(updatelocationEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaLocationRepository.existsById(id)){
          jpaLocationRepository.deleteById(id);
          return true;
        }
        return false;
    }
}
