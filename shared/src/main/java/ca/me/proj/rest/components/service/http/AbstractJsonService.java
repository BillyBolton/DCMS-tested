package ca.me.proj.rest.components.service.http;

import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import ca.me.proj.rest.components.dtos.base.BaseDTO;
import ca.me.proj.rest.components.mapper.http.JsonMapper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
public class AbstractJsonService<D extends BaseDTO> implements IJsonService<D> {

    private String baseUrl;
    private String domain;
    private String errorMessage;
    private TypeReference<List<D>> typeReference;

    @Autowired
    protected RestBusinessService restService;

    @Autowired
    protected JsonMapper<D> jsonService;

    public AbstractJsonService(String baseUrl, String domain, String errorMessage,
            TypeReference<List<D>> typeRef) {
        this.baseUrl = baseUrl;
        this.domain = domain;
        this.errorMessage = errorMessage + " JSon string cannot be converted.";
        this.typeReference = typeRef;


    }

    public List<D> findAll() {
        String method = "/findAll";
        String requestUrl = baseUrl + domain + method;
        log.info("URL: {}", requestUrl);
        try {
            return jsonService.convertJsonToData(
                    restService.getData(requestUrl, typeReference.toString()), typeReference);
        } catch (JsonMappingException ex) {
            log.info(getClass().getName() + errorMessage);
            log.info(ex.getMessage());
            log.info("JSON MAPPING EXCEPTION");
            return null;
        } catch (JsonProcessingException ex) {
            log.error(getClass().getName() + errorMessage);
            log.debug(ex.getMessage());
            log.info("JSON PROCESSING EXCEPTION");
            return null;
        }
    }

}
