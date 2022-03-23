package ca.me.proj.repository.employee;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ca.me.proj.entity.employee.EmployeeEntity;

public interface IEmployeeRepository extends CrudRepository<EmployeeEntity, String> {

   @Override
   @Query(value = "SELECT * from EMPLOYEE", nativeQuery = true)
   public List<EmployeeEntity> findAll();

}
