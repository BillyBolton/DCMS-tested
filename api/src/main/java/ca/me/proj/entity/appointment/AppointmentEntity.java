package ca.me.proj.entity.appointment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "APPOINTMENT")
public class AppointmentEntity {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "type")
    private int type;

    @Column(name = "status")
    private int status;

    @Column(name = "room_number")
    private String room;

    // FKS

    @Column(name = "branch_id")
    private Long branchId;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "patient_id")
    private Long patientId;

}
