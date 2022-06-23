package ca.me.proj.api.repository.appointment;

import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.appointment.AppointmentEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IAppointmentRepository extends IBaseRepository<AppointmentEntity, Long> {

        public List<AppointmentEntity> findByPatientId(String id);

        public List<AppointmentEntity> findByEmployeeId(String id);

        @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from APPOINTMENT a where ((?1 <= a.end_time AND ?1 >= a.start_time) OR (?2 <= a.end_time AND ?2 >= a.start_time)) AND patient_id = ?3",
                        nativeQuery = true)
        public boolean findPatientScheduleConflict(Date start_time, Date end_time, String id);

        @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from APPOINTMENT a where ((?1 <= a.end_time AND ?1 >= a.start_time) OR (?2 <= a.end_time AND ?2 >= a.start_time)) AND employee_id = ?3",
                        nativeQuery = true)
        public boolean findEmployeeScheduleConflict(Date start_time, Date end_time, String id);

}
