package ca.me.proj.controller.appointment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.appointment.AppointmentDTO;
import ca.me.proj.service.appointment.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppoinmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/findAll")
    public List<AppointmentDTO> findAll() {
        return service.findAll();
    }

}
