package com.ConstructoraBolivar.afgc.application.usecases.location;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.UpdateLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;

import java.util.Optional;

public class UpdateLocationUseCasetmlp implements UpdateLocationUseCase {
    private final LocationRepositoryPort locationRepositoryPort;

    public UpdateLocationUseCasetmlp(LocationRepositoryPort locationRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
    }

    @Override
    public Optional<Location> updateLocation(Long id, Location location) {
        return locationRepositoryPort.update(id, location);
    }
}
