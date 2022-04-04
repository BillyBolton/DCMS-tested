package ca.me.proj.service.procedure.type;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public boolean existsById(String id) {
        return repository.existsById(id);
    }

    public ProcedureTypeDTO findById(String id) {
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }
}
