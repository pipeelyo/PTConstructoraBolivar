package com.ConstructoraBolivar.afgc.application.usecases.location;

import com.ConstructoraBolivar.afgc.domain.ports.in.location.DeleteLocationUseCase;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;

public class DeleteLocationUseCasetmlp implements DeleteLocationUseCase {
    private final LocationRepositoryPort locationRepositoryPort;

    public DeleteLocationUseCasetmlp(LocationRepositoryPort locationRepositoryPort) {
        this.locationRepositoryPort = locationRepositoryPort;
    }

    @Override
    public boolean deleteLocation(Long id) {
        return locationRepositoryPort.deleteById(id);
    }
}
