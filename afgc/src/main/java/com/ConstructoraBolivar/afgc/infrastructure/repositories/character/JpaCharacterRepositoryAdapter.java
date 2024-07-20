package com.ConstructoraBolivar.afgc.infrastructure.repositories.character;

import com.ConstructoraBolivar.afgc.domain.models.Character;
import com.ConstructoraBolivar.afgc.domain.ports.out.CharacterRepositoryPort;
import com.ConstructoraBolivar.afgc.infrastructure.entities.CharacterEntity;
import com.ConstructoraBolivar.afgc.infrastructure.entities.LocationEntity;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class JpaCharacterRepositoryAdapter implements CharacterRepositoryPort {

    private final JpaCharacterRepository jpaCharacterRepository;

    public JpaCharacterRepositoryAdapter(JpaCharacterRepository jpaCharacterRepository) {
        this.jpaCharacterRepository = jpaCharacterRepository;
    }

    @Override
    public Character save(Character character) {
        CharacterEntity characterEntity = CharacterEntity.fromDomainModel(character);
        CharacterEntity savedCharacterEntity = jpaCharacterRepository.save(characterEntity);
        return savedCharacterEntity.toDomainModel();
    }

    @Override
    public Optional<Character> findById(Long id) {
        return jpaCharacterRepository.findById(id).map(CharacterEntity::toDomainModel);
    }

    @Override
    public Optional<Character> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Character> findAll() {
        return  jpaCharacterRepository.findAll().stream()
                .map(CharacterEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Character> update(Long id, Character character) {
        if (jpaCharacterRepository.existsById(id)) {
            CharacterEntity characterEntity = CharacterEntity.fromDomainModel(character);
            CharacterEntity updateCharacterEntity = jpaCharacterRepository.save(characterEntity);
            return Optional.of(updateCharacterEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if(jpaCharacterRepository.existsById(id)){
            jpaCharacterRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
