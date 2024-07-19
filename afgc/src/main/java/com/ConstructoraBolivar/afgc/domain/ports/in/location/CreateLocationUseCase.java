package com.ConstructoraBolivar.afgc.domain.ports.in.location;

import com.ConstructoraBolivar.afgc.domain.models.Location;

public interface CreateLocationUseCase {
    Location createLocation(Location location);
}
