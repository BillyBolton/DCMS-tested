package ca.me.proj.repository.treatment;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.treatment.TreatmentEntity;

@Repository
public interface ITreatmentRepository extends CrudRepository<TreatmentEntity, Long> {

}
