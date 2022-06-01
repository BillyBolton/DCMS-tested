package ca.me.proj.api.repository.employee;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.dtos.employee.EmployeeRole;
import ca.me.proj.api.entity.employee.EmployeeEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IEmployeeRepository extends IBaseRepository<EmployeeEntity, String> {

      List<EmployeeEntity> findByRoleAndBranchId(EmployeeRole role, String branchId);

      // @Query(value = "SELECT * from EMPLOYEE WHERE branch_id = ?1 AND role = 'DENTIST'",
      // nativeQuery = true)
      // public List<EmployeeEntity> findDentistByBranchId(String branchId);

      // @Override
      // @Query(value = "SELECT * from EMPLOYEE", nativeQuery = true)
      // public List<EmployeeEntity> findAll();

      // @Query(value = "SELECT * from EMPLOYEE WHERE id = ?1 ", nativeQuery = true)
      // public <Optional> EmployeeEntity findByID(String id);

      // @Query(value = "SELECT CASE WHEN count(e)> 0 THEN true ELSE false end from EMPLOYEE e where
      // e.id = ?1",
      // nativeQuery = true)
      // public boolean existsByID(String id);

      // @Modifying
      // @Query(value = "DELETE from EMPLOYEE e where e.id = ?1", nativeQuery = true)
      // public void deleteByID(String id);

}
