package ca.me.proj.dtos.appointment;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDTO {

    private Long id;
    private String startTime;
    private String endTime;
    private int type;
    private int status;
    private String room;

    // FKS
    private String branchId;
    // private BranchDTO branch;

    private String employeeId;
    // private EmployeeDTO dentist;

    // private PatientDTO patient;
    private String patientId;

    public LocalDateTime getParsedStartTime() {
        return LocalDateTime.parse(startTime);
    }

    public LocalDateTime getParsedEndTime() {
        return LocalDateTime.parse(startTime);
    }

}
