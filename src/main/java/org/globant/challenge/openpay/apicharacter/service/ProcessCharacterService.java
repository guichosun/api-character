package org.globant.challenge.openpay.apicharacter.service;

import org.globant.challenge.openpay.apicharacter.model.res.CharacterResponse;

import java.util.List;
import java.util.Optional;

/**
 * Operation for interact whit external Marvel API
 *
 * @author luis.delcampo
 */
public interface ProcessCharacterService {

    /**
     * Retrieve one {@link CharacterResponse} by id.
     *
     * @param id The id of {@link CharacterResponse}
     *
     * @return The unique {@link CharacterResponse} for the id
     */
    Optional<CharacterResponse> getCharacterById(Long id);

    /**
     * Perform a call to Get characters
     * @return
     */
    List<CharacterResponse> getAllCharacter();

}
