package ca.me.proj.service.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.mapper.appointment.IAppointmentMapper;
import ca.me.proj.repository.appointment.IAppointmentRepository;

@Service
public class AppointmentService {

    @Autowired
    private IAppointmentMapper mapper;

    @Autowired
    private IAppointmentRepository repository;

    public List<AppointmentDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }


}
