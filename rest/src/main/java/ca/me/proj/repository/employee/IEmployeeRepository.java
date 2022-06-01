package ca.me.proj.repository.employee;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.employee.EmployeeEntity;

@Transactional
@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, String> {



      @Query(value = "SELECT * from EMPLOYEE WHERE branch_id = ?1 AND role = 'DENTIST'",
                  nativeQuery = true)
      public List<EmployeeEntity> findDentistByBranchId(String branchId);

      @Override
      @Query(value = "SELECT * from EMPLOYEE", nativeQuery = true)
      public List<EmployeeEntity> findAll();

      @Query(value = "SELECT * from EMPLOYEE WHERE id = ?1 ", nativeQuery = true)
      public <Optional> EmployeeEntity findByID(String id);

      @Query(value = "SELECT CASE WHEN count(e)> 0 THEN true ELSE false end from EMPLOYEE e where e.id = ?1",
                  nativeQuery = true)
      public boolean existsByID(String id);

      @Modifying
      @Query(value = "DELETE from EMPLOYEE e where e.id = ?1", nativeQuery = true)
      public void deleteByID(String id);

}
