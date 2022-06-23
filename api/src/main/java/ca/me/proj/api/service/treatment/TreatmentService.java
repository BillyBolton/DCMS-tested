package ca.me.proj.api.service.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.dtos.treatment.TreatmentDTO;
import ca.me.proj.api.entity.treatment.TreatmentEntity;
import ca.me.proj.api.repository.treatment.ITreatmentRepository;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

@Service
public class TreatmentService extends AbstractBaseServiceImpl<TreatmentDTO, TreatmentEntity, Long> {



    @Autowired
    private ITreatmentRepository repository;



    public boolean existsByProcedureId(String id) {
        return repository.existsByProcedureId(id);
    }


    public List<TreatmentDTO> findByProcedureId(String id) {
        if (!existsByProcedureId(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findByProcedureId(id));
    }

    // public TreatmentDTO createTreatment(TreatmentDTO dto) {
    // dto.setId(null);
    // // TODO validation
    // return save(dto);
    // }

}
