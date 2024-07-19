package com.ConstructoraBolivar.afgc.domain.ports.in.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;

import java.util.Optional;

public interface UpdateLocationUseCase {
    Optional<Location> updateLocation(Long id,Location location);
}
