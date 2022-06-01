package ca.me.proj.api.mapper.patient;

import org.mapstruct.Mapper;
import ca.me.proj.api.dtos.patient.NewPatientDTO;
import ca.me.proj.api.entity.patient.NewPatientEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper
public interface INewPatientMapper extends IBaseMapper<NewPatientDTO, NewPatientEntity> {

}
