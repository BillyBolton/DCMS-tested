package ca.me.proj.api.controller.branch;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ca.me.proj.api.controller.base.AbstractCrudController;
import ca.me.proj.api.dtos.branch.BranchDTO;
import ca.me.proj.api.entity.branch.BranchEntity;

@RestController
@RequestMapping("/branch")
public class BranchController extends AbstractCrudController<BranchDTO, BranchEntity, String> {

}
