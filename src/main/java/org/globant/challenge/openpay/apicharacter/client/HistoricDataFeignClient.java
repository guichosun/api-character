package org.globant.challenge.openpay.apicharacter.client;

import org.globant.challenge.openpay.apicharacter.model.RecordResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * Declarative Interface for a Feign client for historic server.
 *
 * @author luis.delcampo
 */
@FeignClient(value="historicdata", url="${client.service.historicdata.location}")
public interface HistoricDataFeignClient {

    /**
     * To perform a save record.
     *
     * @param recordMap
     * @return
     */
    @PostMapping(value = "${client.service.historicdata.api.uri.records}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    RecordResponse saveRecord(Map<String, String> recordMap);
}
