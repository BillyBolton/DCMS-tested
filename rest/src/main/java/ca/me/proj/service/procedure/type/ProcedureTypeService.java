package ca.me.proj.service.procedure.type;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.dtos.procedure.type.ProcedureTypeDTO;
import ca.me.proj.mapper.procedure.type.IProcedureTypeMapper;
import ca.me.proj.repository.procedure.type.IProcedureTypeRepository;

@Service
public class ProcedureTypeService {

    @Autowired
    private IProcedureTypeMapper mapper;

    @Autowired
    private IProcedureTypeRepository repository;

    public List<ProcedureTypeDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public boolean existsByID(String id) {
        return repository.existsByID(id);
    }

    public ProcedureTypeDTO findByID(String id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByID(id).orElse(null));
    }

    public ProcedureTypeDTO save(ProcedureTypeDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }
}
