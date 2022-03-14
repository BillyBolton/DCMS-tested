package ca.me.proj.mapper.appointment;

import java.util.List;
import org.mapstruct.Mapper;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.entity.appointment.AppointmentEntity;

@Mapper
public interface IAppointmentMapper {

    AppointmentDTO entityToDto(AppointmentEntity entity);

    AppointmentEntity dtoToEntity(AppointmentDTO dto);

    List<AppointmentEntity> dtoToEntity(Iterable<AppointmentDTO> dtos);

    List<AppointmentDTO> entityToDto(Iterable<AppointmentEntity> entities);

}
