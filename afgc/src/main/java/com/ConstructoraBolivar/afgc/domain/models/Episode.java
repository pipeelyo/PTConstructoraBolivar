package com.ConstructoraBolivar.afgc.domain.models;

import java.time.LocalDate;
import java.util.List;

public class Episode {

    private Long id;
    private String name;
    private LocalDate airDate;
    private String episode;
    private List<String> characters;
    private String url;
    private String created;

    public Episode(LocalDate airDate, List<String> characters, String created, String episode, Long id, String name, String url) {
        this.airDate = airDate;
        this.characters = characters;
        this.created = created;
        this.episode = episode;
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public LocalDate getAirDate() {
        return airDate;
    }

    public void setAirDate(LocalDate airDate) {
        this.airDate = airDate;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
