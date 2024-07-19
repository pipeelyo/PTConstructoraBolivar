package com.ConstructoraBolivar.afgc.domain.ports.out;

import com.ConstructoraBolivar.afgc.domain.models.Location;

import java.util.List;
import java.util.Optional;

public interface LocationRepositoryPort {
    Location save(Location episode);
    Optional<Location> findById(Long id);
    Optional<Location> findByName(String name);
    List<Location> findAll();
    Optional<Location> update(Long id, Location episode);
    boolean deleteById(Long id);
}
