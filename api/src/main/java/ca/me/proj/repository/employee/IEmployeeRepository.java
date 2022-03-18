package ca.me.proj.repository.employee;

import org.springframework.data.repository.CrudRepository;
import ca.me.proj.entity.employee.EmployeeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface IEmployeeRepository extends CrudRepository<EmployeeEntity,String> {
    
   @Override
@Query(value = "SELECT * from PATIENT", nativeQuery = true)
public List<EmployeeEntity> findAll();

}