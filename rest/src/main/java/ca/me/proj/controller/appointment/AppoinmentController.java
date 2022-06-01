package ca.me.proj.controller.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.service.appointment.AppointmentService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/appointment")
public class AppoinmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/findAll")
    public List<AppointmentDTO> findAll() {

        return service.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam Long id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public AppointmentDTO findByID(@RequestParam Long id) {
        return service.findByID(id);
    }

    @GetMapping("/findByPatientId")
    public List<AppointmentDTO> findByPatientId(@RequestParam String id) {
        return service.findByPatientId(id);
    }

    @GetMapping("/findByEmployeeId")
    public List<AppointmentDTO> findByEmployeeId(@RequestParam String id) {
        return service.findByEmployeeId(id);
    }

    @PostMapping("/patient/hasScheduleConflict")
    public boolean findPatientScheduleConflict(@RequestBody AppointmentDTO dto) {
        log.info(dto.getStartTime().toString());
        return service.findPatientScheduleConflict(dto);
    }

    @PostMapping("/employee/hasScheduleConflict")
    public boolean findEmployeeScheduleConflict(@RequestBody AppointmentDTO dto) {
        return service.findEmployeeScheduleConflict(dto);
    }

    @PostMapping("/create")
    public AppointmentDTO createAppointment(@RequestBody AppointmentDTO dto) {

        return service.createAppointment(dto);
    }

    @DeleteMapping("/deleteByID")
    public void deletebyId(@RequestParam Long id) {
        service.deletebyId(id);
    }

    @PutMapping("/update")
    public AppointmentDTO update(@RequestBody AppointmentDTO dto) {
        return service.update(dto);
    }


}
