package ca.me.proj.service.treatment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

}
