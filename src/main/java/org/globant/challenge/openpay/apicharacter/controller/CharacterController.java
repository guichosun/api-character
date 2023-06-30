package org.globant.challenge.openpay.apicharacter.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.globant.challenge.openpay.apicharacter.model.res.CharacterResponse;
import org.globant.challenge.openpay.apicharacter.service.ProcessCharacterService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * RestController for the api-caller ms in order to
 * access to the external API.
 */
@Slf4j
@AllArgsConstructor
@RestController
@CrossOrigin(origins = { "http://localhost:4200" })
@RequestMapping(value = "${api.base}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CharacterController {

    private final ProcessCharacterService service;

    /**
     * To get all characters as a response
     */
    @GetMapping()
    public ResponseEntity<List<CharacterResponse>> getCharacters() {
        log.debug("Retrieve all Marvel Characters");

        // There is no time foy error handler. TODO Add a ErrorHandler

        return ResponseEntity.ok(service.getAllCharacter());
    }

    /**
     * To obtain a character by id.
     *
     * @param id the Character's id
     * @return A single {@link CharacterResponse}
     */
    @GetMapping("/{id}")
    public ResponseEntity<CharacterResponse> getCharacter(@PathVariable String id) {
        log.info("The character id {}", id);

        // Get a Character
        CharacterResponse character = service.getCharacterById(id).get();
        return ResponseEntity.ok(character);
    }

}
