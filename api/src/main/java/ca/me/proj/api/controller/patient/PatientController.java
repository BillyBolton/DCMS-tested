package ca.me.proj.api.controller.patient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.patient.PatientDTO;
import ca.me.proj.api.entity.patient.PatientEntity;


@RestController
@RequestMapping("/patient")
public class PatientController extends AbstractCrudController<PatientDTO, PatientEntity, String> {


}
