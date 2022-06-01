package ca.me.proj.controller.branch;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.dtos.branch.BranchDTO;
import ca.me.proj.service.branch.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    private BranchService service;

    @GetMapping("/findAll")
    public List<BranchDTO> findAll() {
        return service.findAll();
    }

    @GetMapping("/existsByID")
    public boolean existsByID(@RequestParam String id) {
        return service.existsByID(id);
    }

    @GetMapping("/findByID")
    public BranchDTO findByID(@RequestParam String id) {
        return service.findByID(id);
    }

    @PostMapping("/create")
    public BranchDTO createPatient(@RequestBody BranchDTO dto) {
        return service.createBranch(dto);
    }

    @DeleteMapping("/deleteByID")
    public void deletePatientByID(@RequestParam String id) {
        service.deleteBranchByID(id);
    }

    @PutMapping("/update")
    public BranchDTO update(@RequestBody BranchDTO dto) {
        return service.update(dto);
    }

}
