package com.ConstructoraBolivar.afgc.infrastructure.config;

import com.ConstructoraBolivar.afgc.application.services.CharacterService;
import com.ConstructoraBolivar.afgc.application.services.EpisodeService;
import com.ConstructoraBolivar.afgc.application.services.LocationService;
import com.ConstructoraBolivar.afgc.application.usecases.character.*;
import com.ConstructoraBolivar.afgc.application.usecases.episode.*;
import com.ConstructoraBolivar.afgc.application.usecases.location.*;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;
import com.ConstructoraBolivar.afgc.domain.ports.out.EpisodeRepositoryPort;
import com.ConstructoraBolivar.afgc.domain.ports.out.ExternalServicePort;
import com.ConstructoraBolivar.afgc.domain.ports.out.LocationRepositoryPort;
import com.ConstructoraBolivar.afgc.infrastructure.adapters.ExternalServiceAdapter;
import com.ConstructoraBolivar.afgc.infrastructure.repositories.Location.JpaLocationRepositoryAdapter;
import com.ConstructoraBolivar.afgc.infrastructure.repositories.character.JpaCharacterRepository;
import com.ConstructoraBolivar.afgc.infrastructure.repositories.character.JpaCharacterRepositoryAdapter;
import com.ConstructoraBolivar.afgc.infrastructure.repositories.episode.JpaEpisodeRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public CharacterService characterService(CharacterRepositoryPort characterRepositoryPort) {
        return  new CharacterService(
                new CreateCharacterUseCaseTmlp(characterRepositoryPort),
                new RetrieveCharacterUseCasetmlp(characterRepositoryPort),
                new UpdateCharacterUseCasetmlp(characterRepositoryPort),
                new DeleteCharacterUseCasetmlp(characterRepositoryPort),
                new GetCharacterUseCasetmlp(characterRepositoryPort)
        );
    }

    @Bean
    public CharacterRepositoryPort characterRepositoryPort(JpaCharacterRepositoryAdapter jpaCharacterRepositoryAdapter) {
        return jpaCharacterRepositoryAdapter;
    }


    @Bean
    public EpisodeService episodeService(EpisodeRepositoryPort episodeRepositoryPort) {
        return  new EpisodeService(
                new CreateEpisodeUseCasetmlp(episodeRepositoryPort),
                new RetrieveEpisodeUseCasetmlp(episodeRepositoryPort),
                new UpdateEpisodeUseCasetmlp(episodeRepositoryPort),
                new DeleteEpisodeUseCasetmlp(episodeRepositoryPort),
                new GetEpisodeUseCasetmlp(episodeRepositoryPort)
        );
    }

    @Bean
    public  EpisodeRepositoryPort episodeRepositoryPort(JpaEpisodeRepositoryAdapter jpaEpisodeRepositoryAdapter) {
        return jpaEpisodeRepositoryAdapter;
    }

    @Bean
    public LocationService locationService(LocationRepositoryPort locationRepositoryPort) {
        return new LocationService(
                new CreateLocationUseCasetmlp(locationRepositoryPort),
                new RetrieveLocationUseCasetmlp(locationRepositoryPort),
                new UpdateLocationUseCasetmlp(locationRepositoryPort),
                new DeleteLocationUseCasetmlp(locationRepositoryPort),
                new GetLocationUseCasetmlp(locationRepositoryPort)
        );
    }

    @Bean
    public LocationRepositoryPort locationRepositoryPort(JpaLocationRepositoryAdapter jpaLocationRepositoryAdapter) {
        return jpaLocationRepositoryAdapter;
    }

    @Bean
    public ExternalServicePort externalServicePort() {
        return new ExternalServiceAdapter();
    }

}
