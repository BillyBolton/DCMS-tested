package ca.me.proj.dtos.appointment;

import java.util.Date;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.dtos.employee.EmployeeDTO;
import ca.me.proj.dtos.patient.PatientDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDTO {

    private Long id;
    private Date startTime;
    private Date endTime;
    private int type;
    private int status;
    private String room;

    // FKS
    // private String branchId;
    private BranchDTO branch;

    // private String employeeId;
    private EmployeeDTO dentist;

    private PatientDTO patient;

}
