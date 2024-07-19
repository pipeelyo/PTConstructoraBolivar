package com.ConstructoraBolivar.afgc.application.usecases.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.CreateLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;

public class CreateLocationUseCasetmlp implements CreateLocationUseCase {
    private final LocationRepositoryPort locationRepositoryPort;

    public CreateLocationUseCasetmlp(LocationRepositoryPort locationRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
    }

    @Override
    public Location createLocation(Location location) {
        return locationRepositoryPort.save(location);
    }
}
