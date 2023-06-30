package org.globant.challenge.openpay.apicharacter.client;

import org.globant.challenge.openpay.apicharacter.model.res.CharacterResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Define methods for a Feign client.
 *
 * @author luis.delcampo
 */
@FeignClient(value="${client.service.marvelapicaller.identifier}",
        url = "${client.service.marvelapicaller.location}"  )
public interface MarvelApiFeignClient {

    /**
     *
     * @return
     */
    @GetMapping(value = "${client.service.marvelapicaller.api.uri.characters}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<CharacterResponse> getCharacters();
    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "${client.service.marvelapicaller.api.uri.byid}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    CharacterResponse getCharacterById(@PathVariable("id") String id);

}
