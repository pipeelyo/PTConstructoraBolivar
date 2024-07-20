package com.ConstructoraBolivar.afgc.infrastructure.repositories.Location;

import com.ConstructoraBolivar.afgc.infrastructure.entities.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaLocationRepository extends JpaRepository<LocationEntity, Long> {
}
