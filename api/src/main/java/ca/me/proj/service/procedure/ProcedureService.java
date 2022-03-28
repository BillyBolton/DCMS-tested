package ca.me.proj.service.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.procedure.ProcedureDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.procedure.IProcedureMapper;
import ca.me.proj.repository.procedure.IProcedureRepository;

@Service
public class ProcedureService {

    @Autowired
    private IProcedureMapper mapper;

    @Autowired
    private IProcedureRepository repository;

    public List<ProcedureDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    public ProcedureDTO findById(String id) {
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }

    public ResponseEntity<String> createProcedure(ProcedureDTO dto) {
        dto.setId(null);
        repository.save(mapper.dtoToEntity(dto));
        return CustomResponseEntity.saveSuccess();
    } 

    public ResponseEntity<String> deletebyId(String id) {
        repository.deleteById(id);
        return CustomResponseEntity.deleteSuccess();
    }

}
