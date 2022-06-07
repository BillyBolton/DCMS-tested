package ca.me.proj.api.unit.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ca.me.proj.api.constants.ApiUri;
import ca.me.proj.api.controller.profile.ProfileController;
import ca.me.proj.api.controller.profile.ProfileUri;
import ca.me.proj.api.dtos.profile.AuthenticationDTO;
import ca.me.proj.api.dtos.profile.AuthenticationRole;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.service.profile.ProfileService;
import ca.me.proj.api.unit.controller.base.BaseControllerUT;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ContextConfiguration(classes = ProfileController.class)
public class ProfileControllerUT extends BaseControllerUT {

    @MockBean
    private ProfileService service;

    // ********************************************************************************************************************
    // Abstracted tests for parent ReadOnlyController
    // ********************************************************************************************************************

    @ParameterizedTest
    @MethodSource("provideProfileDtoData")
    void givenEntityExists_whenFindAll_thenReturnDtoList(ProfileDTO dto) throws Exception {

        String uri = ProfileUri.DOMAIN + ApiUri.FIND_ALL;

        List<ProfileDTO> dtos = List.of(dto);
        when(service.findAll()).thenReturn(dtos);
        assertEquals(toJson(dtos), getRequest(uri));

    }


    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"P_1"})
    void givenEntityExists_whenExistsById_thenReturnTrue(String id) throws Exception {

        String uri = ProfileUri.DOMAIN + ApiUri.EXISTS_BY_ID + "?id=" + id;

        Boolean expected = !(id == null || id.isEmpty());
        when(service.existsById(id)).thenReturn(expected);
        assertEquals(toJson(expected), getRequest(uri));

    }

    @ParameterizedTest
    @MethodSource("provideProfileDtoData")
    void givenEntityExists_whenFindById_thenReturnDto(ProfileDTO dto) throws Exception {

        String id = dto.getId();

        String uri = ProfileUri.DOMAIN + ApiUri.FIND_BY_ID + "?id=" + id;

        when(service.findById(id)).thenReturn(dto);
        assertEquals(toJson(dto), getRequest(uri));

    }

    // ********************************************************************************************************************
    // Abstracted tests for parent CrudController
    // ********************************************************************************************************************

    @ParameterizedTest
    @MethodSource("provideProfileDtoData")
    void givenEntityExists_whenSavingDto_thenReturnDto(ProfileDTO dto) throws Exception {

        String uri = ProfileUri.DOMAIN + ApiUri.SAVE;

        when(service.save(dto)).thenReturn(dto);
        assertEquals(toJson(dto), postRequest(uri, dto));
    }

    @ParameterizedTest
    @MethodSource("provideProfileDtoData")
    void givenEntityExists_whenUpdatingDto_thenReturnDto(ProfileDTO dto) throws Exception {

        String uri = ProfileUri.DOMAIN + ApiUri.SAVE;
        when(service.update(dto)).thenReturn(dto);
        assertEquals(toJson(dto), putRequest(uri, dto));

    }

    @ParameterizedTest
    // @EmptySource
    // @NullSource
    @ValueSource(strings = {"P_1"})
    void givenEntityExists_whenDeleteById_thenSuccessful(String id) throws Exception {

        String uri = ProfileUri.DOMAIN + ApiUri.DELETE_BY_ID + "?id=" + id;
        Boolean expected = (id == null || id.isEmpty());
        assertEquals(toJson(expected), deleteRequest(uri));
    }

    // ********************************************************************************************************************
    // Abstracted tests for ProfileController
    // ********************************************************************************************************************

    @ParameterizedTest
    @MethodSource("provideProfileDtoData")
    void givenEntityExists_whenFindByUsername_thenReturnSuccess(ProfileDTO dto) throws Exception {

        String username = dto.getUsername();

        String uri = ProfileUri.DOMAIN + ProfileUri.FIND_BY_USERNAME + "?username=" + username;

        ProfileDTO expected =
                (username == null || username.isEmpty() || dto == null || dto.getId() == null)
                        ? null
                        : dto;

        when(service.findByUsername(username)).thenReturn(dto);
        assertEquals(toJson(expected), getRequest(uri));
    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"someUserName"})
    void givenEntityExists_whenExistsByUsername_thenReturnSuccess(String username)
            throws Exception {

        String uri = ProfileUri.DOMAIN + ProfileUri.EXISTS_BY_USERNAME + "?username=" + username;
        Boolean expected = !(username == null || username.isEmpty());

        when(service.existsByUsername(username)).thenReturn(expected);
        assertEquals(toJson(expected), getRequest(uri));

    }

    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"someUserName"})
    void givenEntityDoesNotExist_whenDeleteByUsername_thenSuccessful(String username)
            throws Exception {

        String uri = ProfileUri.DOMAIN + ProfileUri.DELETE_BY_USERNAME + "?username=" + username;

        boolean expected = !(username == null || username.isEmpty());

        when(service.deleteByUsername(username)).thenReturn(expected);
        assertEquals(toJson(expected), deleteRequest(uri));
    }

    @ParameterizedTest
    @MethodSource("provideAuthentcationDtoData")
    void givenEntityExists_whenAuthenticating_thenSuccessful(AuthenticationDTO credentials)
            throws Exception {


        String uri = ProfileUri.DOMAIN + ProfileUri.AUTHENTICATE;

        Boolean expected = !(credentials.getUsername() == null
                || credentials.getUsername().isEmpty() || credentials.getPassword() == null
                || credentials.getPassword().isEmpty() || credentials.getRole() == null);

        assertEquals(toJson(expected), postRequest(uri, credentials));
    }



    public static Stream<Arguments> provideProfileDtoData() {
        ProfileDTO dto = new ProfileDTO("P_1", "username", "password", "someFirstName", null, null,
                null, null);

        return Stream.of(Arguments.of(dto));
    }

    public static Stream<Arguments> provideAuthentcationDtoData() {
        String username = "someUsername";
        String password = "somePassword";
        return Stream.of(Arguments.of(new AuthenticationDTO()),
                Arguments.of(new AuthenticationDTO(null, password, AuthenticationRole.PATIENT)),
                Arguments.of(new AuthenticationDTO(username, null, AuthenticationRole.PATIENT)),
                Arguments.of(new AuthenticationDTO(username, password, null),
                        Arguments.of(new AuthenticationDTO(username, password,
                                AuthenticationRole.PATIENT)),
                        new AuthenticationDTO(username, password, AuthenticationRole.EMPLOYEE),
                        new AuthenticationDTO(username, password,
                                AuthenticationRole.RESPONSIBLE_PARTY)));
    }


}
