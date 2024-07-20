package com.ConstructoraBolivar.afgc.infrastructure.entities;

import com.ConstructoraBolivar.afgc.domain.models.Episode;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class EpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long episode_id;
    private String name;
    private LocalDate airDate;
    private String episode;
    @Lob
    @Column(columnDefinition = "TEXT")
    private List<String> characters;
    private String url;
    private String created;

    public EpisodeEntity() {}

    public EpisodeEntity(Long episode_id, String name, LocalDate airDate, String episode, List<String> characters, String url, String created) {
        this.episode_id = episode_id;
        this.name = name;
        this.airDate = airDate;
        this.episode = episode;
        this.characters = characters;
        this.url = url;
        this.created = created;
    }

    public static EpisodeEntity fromEntityModel(Episode episode) {
        return  new EpisodeEntity(
                episode.getId(),
                episode.getName(),
                episode.getAirDate(),
                episode.getEpisode(),
                episode.getCharacters(),
                episode.getUrl(),
                episode.getCreated()
        );
    }

    public static Episode fromDomainModel(Episode episode) {
        return  new Episode(
                episode.getId(),
                episode.getName(),
                episode.getAirDate(),
                episode.getEpisode(),
                episode.getCharacters(),
                episode.getUrl(),
                episode.getCreated()
        );
    }

    public Episode toDomainModel() {
        return new Episode(episode_id, name, airDate, episode, characters, url, created);
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

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Long getId() {
        return episode_id;
    }

    public void setId(Long id) {
        this.episode_id = id;
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
