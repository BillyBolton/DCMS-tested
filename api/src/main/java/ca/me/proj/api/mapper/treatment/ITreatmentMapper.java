package ca.me.proj.api.mapper.treatment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.treatment.TreatmentDTO;
import ca.me.proj.api.entity.treatment.TreatmentEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITreatmentMapper extends IBaseMapper<TreatmentDTO, TreatmentEntity> {

}
