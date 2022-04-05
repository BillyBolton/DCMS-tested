package ca.me.proj.repository.procedure.type;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.procedure.type.ProcedureTypeEntity;

@Repository
public interface IProcedureTypeRepository extends JpaRepository<ProcedureTypeEntity, String> {

    @Override
    @Query(value = "SELECT * from PROCEDURE_TYPE", nativeQuery = true)
    public List<ProcedureTypeEntity> findAll();

    @Query(value = "SELECT * from PROCEDURE_TYPE WHERE id = ?1", nativeQuery = true)
    public Optional<ProcedureTypeEntity> findByID(String id);

    @Query(value = "SELECT CASE WHEN count(a)> 0 THEN true ELSE false end from PROCEDURE_TYPE p where p.id = ?1",
            nativeQuery = true)
    public boolean existsByID(String id);

    @Query(value = "DELETE from from PROCEDURE_TYPE p where p.id = ?1", nativeQuery = true)
    public void deleteByID(String id);

}
