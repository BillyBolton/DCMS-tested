package ca.me.proj.service.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.dtos.treatment.TreatmentDTO;
import ca.me.proj.mapper.treatment.ITreatmentMapper;
import ca.me.proj.repository.treatment.ITreatmentRepository;

@Service
public class TreatmentService {

    @Autowired
    private ITreatmentMapper mapper;

    @Autowired
    private ITreatmentRepository repository;

    public List<TreatmentDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public boolean existsByID(long id) {
        return repository.existsByID(id);
    }

    public boolean existsByProcedureId(String id) {
        return repository.existsByProcedureId(id);
    }

    public TreatmentDTO findByID(long id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByID(id));
    }

    public List<TreatmentDTO> findByProcedureId(String id) {
        if (!existsByProcedureId(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByProcedureId(id));
    }

    public TreatmentDTO createTreatment(TreatmentDTO dto) {
        dto.setId(null);
        // TODO validation
        return save(dto);
    }


    public TreatmentDTO save(TreatmentDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public void deleteByID(long id) {

        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Treatment with id: " + id + " does not exist");
        }

        repository.deleteByID(id);
    }

    public TreatmentDTO update(TreatmentDTO dto) {
        if (!existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Entity with id: " + dto.getId() + " does not exist");
        }
        return save(dto);
    }

}
