package ca.me.proj.api.controller.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.appointment.AppointmentDTO;
import ca.me.proj.api.entity.appointment.AppointmentEntity;
import ca.me.proj.api.service.appointment.AppointmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/appointment")
public class AppoinmentController
        extends AbstractCrudController<AppointmentDTO, AppointmentEntity, Long> {

    @Autowired
    private AppointmentService appointmentService;


    @GetMapping("/findByPatientId")
    public List<AppointmentDTO> findByPatientId(@RequestParam String id) {
        return appointmentService.findByPatientId(id);
    }

    @GetMapping("/findByEmployeeId")
    public List<AppointmentDTO> findByEmployeeId(@RequestParam String id) {
        return appointmentService.findByEmployeeId(id);
    }

    @PostMapping("/patient/hasScheduleConflict")
    public boolean findPatientScheduleConflict(@RequestBody AppointmentDTO dto) {
        log.info(dto.getStartTime().toString());
        return appointmentService.findPatientScheduleConflict(dto);
    }

    @PostMapping("/employee/hasScheduleConflict")
    public boolean findEmployeeScheduleConflict(@RequestBody AppointmentDTO dto) {
        return appointmentService.findEmployeeScheduleConflict(dto);
    }



}
