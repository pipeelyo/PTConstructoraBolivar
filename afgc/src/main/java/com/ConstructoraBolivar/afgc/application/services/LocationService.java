package com.ConstructoraBolivar.afgc.application.services;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.in.location.*;

import java.util.List;
import java.util.Optional;

public class LocationService implements CreateLocationUseCase, RetrieveLocationUseCase, UpdateLocationUseCase, DeleteLocationUseCase, GetLocationUseCase {

    private final CreateLocationUseCase createLocationUseCase;
    private final RetrieveLocationUseCase retrieveLocationUseCase;
    private final UpdateLocationUseCase updateLocationUseCase;
    private final DeleteLocationUseCase deleteLocationUseCase;
    private final GetLocationUseCase getLocationUseCase;

    public LocationService(CreateLocationUseCase createLocationUseCase, RetrieveLocationUseCase retrieveLocationUseCase, UpdateLocationUseCase updateLocationUseCase, DeleteLocationUseCase deleteLocationUseCase, GetLocationUseCase getLocationUseCase) {
        this.createLocationUseCase = createLocationUseCase;
        this.retrieveLocationUseCase = retrieveLocationUseCase;
        this.updateLocationUseCase = updateLocationUseCase;
        this.deleteLocationUseCase = deleteLocationUseCase;
        this.getLocationUseCase = getLocationUseCase;
    }


    @Override
    public Location createLocation(Location location) {
        return createLocationUseCase.createLocation(location);
    }

    @Override
    public boolean deleteLocation(Long id) {
        return deleteLocationUseCase.deleteLocation(id);
    }

    @Override
    public Optional<Location> getLocation(Long id) {
        return retrieveLocationUseCase.getLocation(id);
    }

    @Override
    public List<Location> getLocations() {
        return retrieveLocationUseCase.getLocations();
    }

    @Override
    public Optional<Location> updateLocation(Long id,Location location) {
        return updateLocationUseCase.updateLocation(id, location);
    }

    @Override
    public Optional<Location> getLocationName(String name) {
        return getLocationUseCase.getLocationName(name);
    }
}
