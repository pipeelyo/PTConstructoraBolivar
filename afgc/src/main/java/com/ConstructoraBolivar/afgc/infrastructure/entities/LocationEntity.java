package com.ConstructoraBolivar.afgc.infrastructure.entities;

import com.ConstructoraBolivar.afgc.domain.models.Location;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long location_id;
    private String name;
    private String type;
    private String dimension;
    @Lob
    @Column(columnDefinition = "TEXT")
    private List<String> residents;
    private String url;
    private String created;

    public LocationEntity() {}

    public LocationEntity(Long location_id, String name, String type, String dimension, List<String> residents,  String url, String created) {
        this.location_id = location_id;
        this.name = name;
        this.type = type;
        this.dimension = dimension;
        this.residents = residents;
        this.url = url;
        this.created = created;
    }

    public static LocationEntity fromLocationModel(Location location) {
        return new LocationEntity(
          location.getId(),
          location.getName(),
          location.getType(),
                location.getDimension(),
                location.getResidents(),
                location.getUrl(),
                location.getCreated()
        );
    }

    public Location toDomainModel() {
        return new Location(location_id, name, type, dimension, residents, url, created);
    }

    public String getCreated() {
        return this.created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Long getId() {
        return location_id;
    }

    public void setId(Long id) {
        this.location_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getResidents() {
        return residents;
    }

    public void setResidents(List<String> residents) {
        this.residents = residents;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
