package ca.me.proj.repository.appointment;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.appointment.AppointmentEntity;

@Repository
public interface IAppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    @Override
    @Query(value = "SELECT * from APPOINTMENT", nativeQuery = true)
    public List<AppointmentEntity> findAll();


}
