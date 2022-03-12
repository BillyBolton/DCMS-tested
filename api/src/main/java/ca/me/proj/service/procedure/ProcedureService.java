package ca.me.proj.service.procedure;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.procedure.ProcedureDTO;
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

}
