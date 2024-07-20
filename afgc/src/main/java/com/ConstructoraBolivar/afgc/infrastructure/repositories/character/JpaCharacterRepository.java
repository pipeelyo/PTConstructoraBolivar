package com.ConstructoraBolivar.afgc.infrastructure.repositories.character;

import com.ConstructoraBolivar.afgc.infrastructure.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaCharacterRepository  extends JpaRepository<CharacterEntity, Long> {
}
