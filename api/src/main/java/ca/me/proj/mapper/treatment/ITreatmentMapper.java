package ca.me.proj.mapper.treatment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.treatment.TreatmentDTO;
import ca.me.proj.entity.treatment.TreatmentEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITreatmentMapper extends IBaseMapper<TreatmentDTO, TreatmentEntity> {

}
