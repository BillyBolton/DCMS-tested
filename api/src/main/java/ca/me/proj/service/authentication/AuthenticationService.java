package ca.me.proj.service.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.profile.AuthenticationDTO;
import ca.me.proj.dtos.profile.AuthenticationRole;
import ca.me.proj.dtos.profile.ProfileDTO;
import ca.me.proj.mapper.employee.IEmployeeMapper;
import ca.me.proj.mapper.patient.IPatientMapper;
import ca.me.proj.mapper.profile.IProfileMapper;
import ca.me.proj.repository.employee.IEmployeeRepository;
import ca.me.proj.repository.patient.IPatientRepository;
import ca.me.proj.repository.profile.IProfileRepository;

@Service
public class AuthenticationService {

    protected static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private IProfileMapper profileMapper;

    @Autowired
    private IPatientMapper patientMapper;

    @Autowired
    private IEmployeeMapper employeeMapper;

    @Autowired
    private IProfileRepository profileRepository;

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private IEmployeeRepository employeeRepository;


    public boolean authenticate(AuthenticationDTO credentials) {
        if (!profileRepository.existsByUsername(credentials.getUsername())) {
            return false;
        }
        ProfileDTO dto = profileMapper
                .entityToDto(profileRepository.findByUsername(credentials.getUsername()));
        boolean matchingCredentials = encoder.matches(credentials.getPassword(), dto.getPassword());

        AuthenticationRole role = credentials.getRole();
        switch (role) {
            case PATIENT:
                return matchingCredentials && patientRepository.existsById(dto.getId());
            case EMPLOYEE:
                return matchingCredentials && employeeRepository.existsById(dto.getId());
            default:
                return false;
        }
    }
}
