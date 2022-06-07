package ca.me.proj.api.unit.controller.base;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import ca.me.proj.api.config.TestWebConfig;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public abstract class UTBaseController {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected TestWebConfig config;

    protected String getRequest(String uri) throws Exception {
        return stringifyRequest(
                mvc.perform(get(uri)).andDo(print()).andExpect(status().isOk()).andReturn());
    }

    protected String postRequest(String uri, Object body) throws Exception {
        return stringifyRequest(mvc
                .perform(post(uri).content(toJson(body)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn());
    }

    protected String putRequest(String uri, Object body) throws Exception {
        return stringifyRequest(mvc
                .perform(put(uri).content(toJson(body)).contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn());
    }

    protected String deleteRequest(String uri) throws Exception {
        return stringifyRequest(
                mvc.perform(delete(uri)).andDo(print()).andExpect(status().isOk()).andReturn());
    }

    private String stringifyRequest(MvcResult mvcResult) throws Exception {
        return mvcResult.getResponse().getContentAsString();
    }

    protected String toJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
