package com.ConstructoraBolivar.afgc.domain.ports.in.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;

import java.util.Optional;

public interface GetLocationUseCase {
    Optional<Location> getLocationName(String name);
}
