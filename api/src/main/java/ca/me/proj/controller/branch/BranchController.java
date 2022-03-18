package ca.me.proj.controller.branch;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.service.branch.BranchService;
import io.micrometer.core.ipc.http.HttpSender.Response;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/branch")
public class BranchController {
    
    @Autowired
    private BranchService branchService;

    @GetMapping("/findAll")
    public List<BranchDTO> findAll() {
        return branchService.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id){
        return branchService.existsByID(id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPatient(@RequestBody BranchDTO branchDTO){
        ResponseEntity<String> response = branchService.createBranch(branchDTO);
        return response;
    }

    @DeleteMapping("/deleteByID")
    public ResponseEntity<String> deletePatientByID(@RequestParam String id){
        return branchService.deleteBranchByID(id);
    }

}
