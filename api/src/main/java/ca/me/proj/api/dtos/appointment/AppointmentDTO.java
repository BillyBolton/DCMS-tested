package ca.me.proj.api.dtos.appointment;

import java.time.LocalDateTime;
import ca.me.proj.api.dtos.base.BaseDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDTO extends BaseDTO {


    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
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

    // @JsonIgnore
    // public LocalDateTime setStartTimeString(String datetime) {
    // return this.startTime = LocalDateTime.parse(datetime);
    // }

    // @JsonIgnore
    // public LocalDateTime setEndTimeString(String datetime) {
    // return this.startTime = LocalDateTime.parse(datetime);
    // }



}
