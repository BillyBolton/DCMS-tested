package ca.me.proj.api.mapper.appointment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.api.dtos.appointment.AppointmentDTO;
import ca.me.proj.api.entity.appointment.AppointmentEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAppointmentMapper extends IBaseMapper<AppointmentDTO, AppointmentEntity> {

    // AppointmentDTO entityToDto(AppointmentEntity entity);

    // AppointmentEntity dtoToEntity(AppointmentDTO dto);

}
