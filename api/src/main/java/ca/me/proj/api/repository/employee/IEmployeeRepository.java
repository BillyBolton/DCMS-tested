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


}
