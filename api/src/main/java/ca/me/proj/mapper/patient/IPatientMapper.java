package ca.me.proj.mapper.patient;

import java.util.List;
import org.mapstruct.Mapper;
import ca.me.proj.dtos.patient.PatientDTO;
import ca.me.proj.entity.patient.PatientEntity;

@Mapper
public interface IPatientMapper {
    PatientDTO entityToDto(PatientEntity entity);

    PatientEntity dtoToEntity(PatientDTO dto);

    List<PatientEntity> dtoToEntity(Iterable<PatientDTO> dtos);

    List<PatientDTO> entityToDto(Iterable<PatientEntity> entities);
    
}
