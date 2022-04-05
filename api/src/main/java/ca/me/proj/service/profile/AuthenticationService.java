package ca.me.proj.service.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.AuthenticationDTO;
import ca.me.proj.dtos.profile.AuthenticationRole;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.exceptions.AuthenticationException;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.profile.IProfileMapper;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.repository.profile.IProfileRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthenticationService {

    protected static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    protected IProfileMapper mapper;

    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;

    public boolean authenticate(AuthenticationDTO credentials) {
        boolean authenticated = false;
        if (!profileRepository.existsByUsername(credentials.getUsername())) {
            throw new ResourceNotFoundException(
                    "Profile with username: " + credentials.getUsername() + " does not exist");
        }
        ProfileDTO dto =
                mapper.entityToDto(profileRepository.findByUsername(credentials.getUsername()));
        boolean matchingCredentials = encoder.matches(credentials.getPassword(), dto.getPassword());

        AuthenticationRole role = credentials.getRole();
        switch (role) {
            case PATIENT:
                authenticated = matchingCredentials && patientRepository.existsByID(dto.getId());
                break;
            case EMPLOYEE:
                authenticated = matchingCredentials && employeeRepository.existsByID(dto.getId());
                break;
            default:
                authenticated = false;
                break;
        }

        if (!authenticated) {
            throw new AuthenticationException("Authentication failed. Invalid credentials.");
        }

        return authenticated;
    }
}
