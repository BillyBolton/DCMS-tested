package ca.me.proj.mapper.appointment;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.entity.appointment.AppointmentEntity;
import ca.me.proj.mapper.base.IBaseMapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAppointmentMapper extends IBaseMapper<AppointmentDTO, AppointmentEntity> {

    // AppointmentDTO entityToDto(AppointmentEntity entity);

    // AppointmentEntity dtoToEntity(AppointmentDTO dto);

}
