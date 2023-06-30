package org.globant.challenge.openpay.apicharacter.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicharacter.client.HistoricDataFeignClient;
import org.globant.challenge.openpay.apicharacter.client.MarvelApiFeignClient;
import org.globant.challenge.openpay.apicharacter.model.res.CharacterResponse;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Service
@Slf4j
@AllArgsConstructor
public class ProcessCharacterServiceImpl implements
        ProcessCharacterService {


    private final HistoricDataFeignClient historicFeignClient;

    private final MarvelApiFeignClient marvelFeignClient;

    /**
     * @see ProcessCharacterService#getAllCharacter()
     */
    @Override
    public List<CharacterResponse> getAllCharacter() {

        log.debug("Returns all characters");

        // Call marvel-api-caller service
        List<CharacterResponse> characters = marvelFeignClient.getCharacters();
        log.info("Characters: {}",characters.size());

        // Record the resource
        recordHistoric("getAllCharacters");

        return characters;
    }

    /**
     * @see ProcessCharacterService#getCharacterById(String)
     */
    @Override
    public Optional<CharacterResponse> getCharacterById(String id) {

        log.info("Return a Character");

        // Call marvel-api-caller service
        CharacterResponse characterRes = marvelFeignClient.getCharacterById(id);

        // Record the resource
        recordHistoric("wr56Characters-By-id");

        return Optional.of(characterRes);
    }

    private void recordHistoric(String resource) {
        log.info("Going to save a record");

        Map<String, String> body = new HashMap<>(2);
        body.put("resource", resource);
        body.put("timestamp", new Date().toString());

        historicFeignClient.saveRecord(body);

    }
}
