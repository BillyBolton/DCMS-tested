package ca.me.proj.api.repository.procedure;

import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import ca.me.proj.api.entity.procedure.ProcedureEntity;
import ca.me.proj.api.repository.base.IBaseRepository;

@Transactional
@Repository
public interface IProcedureRepository extends IBaseRepository<ProcedureEntity, String> {

    // @Override
    // @Query(value = "SELECT * from PROCEDURE", nativeQuery = true)
    // public List<ProcedureEntity> findAll();

    // @Query(value = "SELECT * from PROCEDURE WHERE id = ?1", nativeQuery = true)
    // public Optional<ProcedureEntity> findByID(String id);

    // @Query(value = "SELECT CASE WHEN count(p)> 0 THEN true ELSE false end from PROCEDURE p where
    // p.id = ?1",
    // nativeQuery = true)
    // public boolean existsByID(String id);

    // @Modifying
    // @Query(value = "DELETE from PROCEDURE p where p.id = ?1", nativeQuery = true)
    // public void deleteByID(String id);

}
