package ca.me.proj.repository.procedure.type;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ca.me.proj.entity.procedure.type.ProcedureTypeEntity;

@Repository
public interface IProcedureTypeRepository extends CrudRepository<ProcedureTypeEntity, String> {

    @Override
    @Query(value = "SELECT * from PROCEDURE_TYPE", nativeQuery = true)
    public List<ProcedureTypeEntity> findAll();

    @Query(value = "SELECT * from PROCEDURE_TYPE WHERE id = ?1", nativeQuery = true)
    public Optional<ProcedureTypeEntity> findById(String id);

}
