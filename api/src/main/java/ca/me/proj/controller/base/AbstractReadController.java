package ca.me.proj.controller.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.me.proj.constants.ApiUri;
import ca.me.proj.dtos.base.BaseDTO;
import ca.me.proj.entity.base.AbstractBaseEntity;
import ca.me.proj.service.base.AbstractBaseServiceImpl;

public abstract class AbstractReadController<D extends BaseDTO, E extends AbstractBaseEntity> {

    protected AbstractBaseServiceImpl<D, E> service;

    @Autowired
    public void setService(AbstractBaseServiceImpl<D, E> service) {
        this.service = service;
    }

    @GetMapping(ApiUri.EXISTS_BY_ID)
    public boolean existsById(@RequestParam("id") Long id) {
        return service.existsById(id);
    }

    @GetMapping(ApiUri.FIND_ALL)
    public List<D> findAll() {
        return service.findAll();
    }

    @GetMapping(ApiUri.FIND_BY_ID)
    public D findById(@RequestParam long id) {
        return service.findById(id);
    }

}
