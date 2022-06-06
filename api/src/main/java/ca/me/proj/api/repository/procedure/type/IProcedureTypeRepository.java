package ca.me.proj.api.repository.procedure.type;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.procedure.type.ProcedureTypeEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IProcedureTypeRepository extends IBaseRepository<ProcedureTypeEntity, String> {

    // @Override
    // @Query(value = "SELECT * from PROCEDURE_TYPE", nativeQuery = true)
    // public List<ProcedureTypeEntity> findAll();

    // @Query(value = "SELECT * from PROCEDURE_TYPE WHERE id = ?1", nativeQuery = true)
    // public Optional<ProcedureTypeEntity> findByID(String id);

    // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PROCEDURE_TYPE p
    // where p.id = ?1",
    // nativeQuery = true)
    // public boolean existsById(String id);

    // @Modifying
    // @Query(value = "DELETE from PROCEDURE_TYPE p where p.id = ?1", nativeQuery = true)
    // public void deleteByID(String id);

}
