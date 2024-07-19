package com.ConstructoraBolivar.afgc.domain.ports.in.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;

import java.util.List;
import java.util.Optional;

public interface RetrieveLocationUseCase {
    Optional<Location> getLocation(Long id);
    List<Location> getLocations();
}
