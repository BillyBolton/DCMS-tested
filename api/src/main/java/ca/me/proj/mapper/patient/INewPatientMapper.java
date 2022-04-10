package ca.me.proj.mapper.patient;

import org.mapstruct.Mapper;
import ca.me.proj.dtos.patient.NewPatientDTO;
import ca.me.proj.entity.patient.NewPatientEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper
public interface INewPatientMapper extends IBaseMapper<NewPatientDTO, NewPatientEntity> {

}
