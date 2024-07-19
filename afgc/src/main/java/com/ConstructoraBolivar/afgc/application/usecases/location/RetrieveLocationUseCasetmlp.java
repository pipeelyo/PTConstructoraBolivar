package com.ConstructoraBolivar.afgc.application.usecases.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.RetrieveLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveLocationUseCasetmlp implements RetrieveLocationUseCase {
    private final LocationRepositoryPort locationRepositoryPort;

    public RetrieveLocationUseCasetmlp(LocationRepositoryPort locationRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
    }

    @Override
    public Optional<Location> getLocation(Long id) {
        return locationRepositoryPort.findById(id);
    }

    @Override
    public List<Location> getLocations() {
        return locationRepositoryPort.findAll();
    }
}
