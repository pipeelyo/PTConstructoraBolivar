package com.ConstructoraBolivar.afgc.infrastructure.entities;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long character_id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    @ManyToOne
    private LocationEntity origin;
    @ManyToOne
    @JoinColumn(name = "id")
    @JsonIgnore
    private LocationEntity location;
    private String image;
    @ManyToMany
    private List<EpisodeEntity> episode;
    private String url;
    private String created;

    public CharacterEntity() {}

    public CharacterEntity(Long character_id, String name, String status, String species, String type, String gender, LocationEntity origin, LocationEntity location, String image, String url, String created) {
        this.character_id = character_id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.url = url;
        this.created = created;
    }

    public static CharacterEntity fromDomainModel(Character character) {
        return new CharacterEntity(
                character.getId(),
                character.getName(),
                character.getStatus(),
                character.getSpecies(),
                character.getType(),
                character.getGender(),
                character.getOrigin(),
                character.getLocation(),
                character.getImage(),
                character.getUrl(),
                character.getCreated());
    }

    public Character toDomainModel() {
        return new Character(character_id, name, status, species, type, gender, (Location) origin, (Location) location, image, url, created);
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public List<EpisodeEntity> getEpisode() {
        return episode;
    }

    public void setEpisode(List<EpisodeEntity> episode) {
        this.episode = episode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return character_id;
    }

    public void setId(Long id) {
        this.character_id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationEntity getOrigin() {
        return origin;
    }

    public void setOrigin(LocationEntity origin) {
        this.origin = origin;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
