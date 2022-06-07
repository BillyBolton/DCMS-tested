package ca.me.proj.api.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.dtos.profile.ProfileDTO;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.mapper.profile.IProfileMapper;
import ca.me.proj.api.repository.profile.IProfileRepository;
import ca.me.proj.api.service.profile.AuthenticationService;
import ca.me.proj.api.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ProfileServiceUnitTests {

    @Mock
    private IProfileMapper mapper;

    @Mock
    private IProfileRepository repository;

    @Mock
    private AuthenticationService authenticationService;

    // @Mock
    // private AddressService addressService;

    @InjectMocks
    private ProfileService service;

    @ParameterizedTest
    @EmptySource
    @NullSource
    @ValueSource(strings = {"yodaBaes"})
    void givenEntityExists_whenFindByUsername_thenReturnTrue(String username) {


        if (username == null || username.isEmpty()) {
            assertThrows(ResourceNotFoundException.class, () -> service.findByUsername(username));
        } else {

            ProfileDTO dto = new ProfileDTO();
            ProfileEntity entity = new ProfileEntity();
            when(service.existsByUsername(username)).thenReturn(true);
            when(mapper.entityToDto(entity)).thenReturn(dto);
            when(repository.findByUsername(username)).thenReturn(entity);
            assertEquals(dto, service.findByUsername(username));
        }

    }

}
