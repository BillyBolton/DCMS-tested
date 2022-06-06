package ca.me.proj.api.unit.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import ca.me.proj.api.constants.ApiUri;
import ca.me.proj.api.controller.profile.ProfileController;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.service.profile.ProfileService;
import ca.me.proj.api.unit.controller.base.BaseControllerUT;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = ProfileController.class)
public class ProfileControllerUT extends BaseControllerUT {

    @MockBean
    private ProfileService service;

    @Test
    void givenEntityExists_whenFindAll_thenReturnDtoList() throws Exception {
        when(service.findAll()).thenReturn(List.of(validProfileDTO()));

        MvcResult mvcResult;

        String uri = "/profile" + ApiUri.FIND_ALL;

        mvcResult = mvc.perform(get(uri)).andDo(print()).andExpect(status().isOk()).andReturn();
        String response = mvcResult.getResponse().getContentAsString();
        assertTrue(response.contains(
                "[{\"id\":null,\"username\":\"username\",\"password\":\"password\",\"firstName\":\"someFirstName\",\"middleName\":null,\"lastName\":null,\"address\":null,\"dob\":null}]"));
    }


    private ProfileDTO validProfileDTO() {
        ProfileDTO dto = new ProfileDTO();
        dto.setUsername("username");
        dto.setPassword("password");
        dto.setFirstName("someFirstName");
        return dto;
    }

}
