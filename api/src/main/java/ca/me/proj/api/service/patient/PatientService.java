package ca.me.proj.api.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.dtos.patient.PatientDTO;
import ca.me.proj.api.entity.patient.PatientEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;
import ca.me.proj.api.service.profile.ProfileService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PatientService extends AbstractBaseServiceImpl<PatientDTO, PatientEntity, String> {

    @Autowired
    private ProfileService profileService;


    public PatientDTO create(PatientDTO dto) {


        if (profileService.existsByUsername(dto.getProfile().getUsername())) {
            return save(dto);
        }

        if (profileService.existsById(dto.getProfile().getId())) {
            return save(dto);
        }

        dto.setProfile(profileService.create(dto.getProfile()));
        return save(dto);

    }

    @Override
    public PatientDTO update(PatientDTO dto) {
        if (!existsById(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Patient with id: " + dto.getId() + " does not exist");
        }

        dto.setProfile(profileService.update(dto.getProfile()));
        dto.getProfile().setDOB(dto.getProfile().getDOB().plusDays(1L));

        return save(dto);
    }
}
