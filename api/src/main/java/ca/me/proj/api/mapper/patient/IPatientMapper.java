package ca.me.proj.api.mapper.patient;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.patient.PatientDTO;
import ca.me.proj.api.entity.patient.PatientEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPatientMapper extends IBaseMapper<PatientDTO, PatientEntity> {
    // PatientDTO entityToDto(PatientEntity entity);

    // PatientEntity dtoToEntity(PatientDTO dto);

}
