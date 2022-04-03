package ca.me.proj.dtos.appointment;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AppointmentDTO {

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

    @JsonIgnore
    public LocalDateTime setStartTimeString(String datetime) {
        return this.startTime = LocalDateTime.parse(datetime);
    }

    @JsonIgnore
    public LocalDateTime setEndTimeString(String datetime) {
        return this.startTime = LocalDateTime.parse(datetime);
    }

    public String getStartTimeString() {
        return this.startTime.toString();
    }

    public String getEndTimeString() {
        return this.endTime.toString();
    }


}
