package ca.me.proj.dtos.appointment;

import java.util.Date;
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
    private Long branchId;
    private Long employeeId;
    private Long patientId;

}
