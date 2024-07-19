package com.ConstructoraBolivar.afgc.application.usecases.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.GetLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;

import java.util.Optional;

public class GetLocationUseCasetmlp implements GetLocationUseCase {
    private final LocationRepositoryPort locationRepositoryPort;

    public GetLocationUseCasetmlp(LocationRepositoryPort locationRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
    }

    @Override
    public Optional<Location> getLocationName(String name) {
        return locationRepositoryPort.findByName(name);
    }
}
