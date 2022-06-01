package ca.me.proj.service.branch;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.dtos.exceptions.ResourceNotFoundException;
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

    public BranchDTO createBranch(BranchDTO dto) {
        dto.setId(null);
        return save(dto);
    }

    public void deleteBranchByID(String id) {
        deleteValidation(id);
        repository.deleteByID(id);
    }

    public boolean existsByID(String id) {
        if (!existsByID(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return repository.existsByID(id);
    }

    public BranchDTO findByID(String id) {
        return mapper.entityToDto(repository.findByID(id));
    }

    public BranchDTO save(BranchDTO dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public void deleteValidation(String id) {
        if (!repository.existsByID(id)) {
            throw new ResourceNotFoundException("Branch ID does not exist");
        }
    }

    public BranchDTO update(BranchDTO dto) {
        if (!existsByID(dto.getId())) {
            throw new ResourceNotFoundException(
                    "Entity with id: " + dto.getId() + " does not exist");
        }
        return save(dto);
    }



}
