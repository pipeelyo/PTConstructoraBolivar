package com.ConstructoraBolivar.afgc.domain.ports.out;

import com.ConstructoraBolivar.afgc.domain.models.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterRepositoryPort {
    Character save(Character character);
    Optional<Character> findById(Long id);
    Optional<Character> findByName(String name);
    List<Character> findAll();
    Optional<Character> update(Long id, Character character);
    boolean deleteById(Long id);
}
