package ca.me.proj.repository.procedure;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

import ca.me.proj.entity.procedure.ProcedureEntity;

@Repository
public interface IProcedureRepository extends CrudRepository<ProcedureEntity, String> {

    @Override
    @Query(value = "SELECT * from PROCEDURE", nativeQuery = true)
    public List<ProcedureEntity> findAll();

    @Override
    @Query(value = "SELECT * from PROCEDURE WHERE id = ?1", nativeQuery = true)
    public Optional<ProcedureEntity> findById(String id);
}
