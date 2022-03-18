package ca.me.proj.service.branch;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ca.me.proj.dtos.branch.BranchDTO;
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

    public ResponseEntity<String> createBranch(BranchDTO branchDTO){
            repository.save(mapper.dtoToEntity(branchDTO));
            return new ResponseEntity<String>("Success",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<String> deleteBranchByID(String id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<String>("Success: Deleted ID: " + id,HttpStatus.ACCEPTED);
        }
        else{        
            return new ResponseEntity<String>(
            "ID does not exist", 
            HttpStatus.BAD_REQUEST);
        }   
    }

    public boolean existsByID(String id){
        return repository.existsById(id);
    }

    
    
}
