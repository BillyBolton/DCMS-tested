package ca.me.proj.entity.appointment;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import ca.me.proj.entity.branch.NestedBranchEntity;
import ca.me.proj.entity.employee.EmployeeEntity;
import ca.me.proj.entity.patient.PatientEntity;
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

    @ManyToOne
    @JoinColumn(name = "branch_id", nullable = false)
    private NestedBranchEntity branch;

    // @Column(name = "employee_id")
    // private String employeeId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity dentist;


    // @Column(name = "patient_id")
    // private String patientId;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

}
