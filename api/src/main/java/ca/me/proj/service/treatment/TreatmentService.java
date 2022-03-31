package ca.me.proj.service.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.treatment.TreatmentDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
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

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public boolean existsByProcedureId(String id) {
        return repository.existsByProcedureId(id);
    }

    public TreatmentDTO findById(Long id){
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }

    public List<TreatmentDTO> findByProcedureId(String id){
        return mapper.entityToDto(repository.findByProcedureId(id));
    }

    public ResponseEntity<String> createTreatment(TreatmentDTO dto){
        dto.setId(null);
        repository.save(mapper.dtoToEntity(dto));
        return CustomResponseEntity.saveSuccess();
    }

    public ResponseEntity<String> deleteById(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        return CustomResponseEntity.deleteSuccess();
        }
        else{
            return CustomResponseEntity.badRequestDNE();
        }
    }

}
