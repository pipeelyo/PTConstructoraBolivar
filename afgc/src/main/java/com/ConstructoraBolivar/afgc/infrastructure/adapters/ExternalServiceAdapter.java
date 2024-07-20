package com.ConstructoraBolivar.afgc.infrastructure.adapters;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.models.Episode;
import com.ConstructoraBolivar.afgc.domain.models.Location;
import com.ConstructoraBolivar.afgc.domain.ports.out.ExternalServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    //https://rickandmortyapi.com/api/character
    //https://rickandmortyapi.com/api/location
    //https://rickandmortyapi.com/api/episode

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter() {
        this.restTemplate = new RestTemplate();
    }


    @Override
    public Character getCharacter(Long id) {
        String apiUrl = "https://rickandmortyapi.com/api/character/"+id;
        ResponseEntity<Character> response = restTemplate.getForEntity(apiUrl, Character.class);
        Character character = response.getBody();
        if(character != null) {
            return new Character(
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
                    character.getCreated()
            );
        }
        return null;
    }

    @Override
    public Episode getEpisode(Long id) {
        String apiUrl = "https://rickandmortyapi.com/api/episode/"+id;
        ResponseEntity<Episode> response = restTemplate.getForEntity(apiUrl, Episode.class);
        Episode episode = response.getBody();
        if(episode != null) {
            return new Episode(
                    episode.getId(),
                    episode.getName(),
                    episode.getAirDate(),
                    episode.getEpisode(),
                    episode.getCharacters(),
                    episode.getUrl(),
                    episode.getCreated()
            );
        }
        return null;
    }

    @Override
    public Location getLocation(Long id) {
        String apiUrl = "https://rickandmortyapi.com/api/location/"+id;
        ResponseEntity<Location> response = restTemplate.getForEntity(apiUrl, Location.class);
        Location location = response.getBody();
        if(location != null) {
            return new Location(
                    location.getId(),
                    location.getName(),
                    location.getType(),
                    location.getDimension(),
                    location.getResidents(),
                    location.getUrl(),
                    location.getCreated()
            );
        }
        return null;
    }




}
