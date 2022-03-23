package ca.me.proj.service.branch;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.entity.response.CustomResponseEntity;
import ca.me.proj.mapper.branch.IBranchMapper;
import ca.me.proj.repository.branch.IBranchRepository;

@Service
public class BranchService {

    @Autowired
    private IBranchMapper mapper;

    @Autowired
    private IBranchRepository repository;

    public List<BranchDTO> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public ResponseEntity<String> createBranch(BranchDTO dto) {

        dto.setId(null);

        repository.save(mapper.dtoToEntity(dto));
        return CustomResponseEntity.saveSuccess();
    }

    public ResponseEntity<String> deleteBranchByID(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return CustomResponseEntity.deleteSuccess();
        } else {
            return CustomResponseEntity.badRequestDNE();
        }
    }

    public boolean existsByID(String id) {
        return repository.existsById(id);
    }



}
