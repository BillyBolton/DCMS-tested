package ca.me.proj.service.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.procedure.ProcedureDTO;
import ca.me.proj.exceptions.ResourceNotFoundException;
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

    public boolean existsByID(String id) {
        return repository.existsByID(id);
    }

    public ProcedureDTO findByID(String id) {
        return mapper.entityToDto(repository.findByID(id).orElse(null));
    }

    public ProcedureDTO createProcedure(ProcedureDTO dto) {
        dto.setId(null);
        return save(dto);

    }

    public ProcedureDTO save(ProcedureDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public void deletebyId(String id) {

        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Procedure ID does not exist");
        }

        repository.deleteByID(id);
    }

}
