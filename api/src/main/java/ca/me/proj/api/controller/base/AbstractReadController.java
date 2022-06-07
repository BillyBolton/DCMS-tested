package ca.me.proj.api.controller.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ca.me.proj.api.constants.ApiUri;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.entity.base.AbstractBaseEntity;
import ca.me.proj.api.service.base.AbstractBaseServiceImpl;

public abstract class AbstractReadController<D extends BaseDTO, E extends AbstractBaseEntity, PK> {

    protected AbstractBaseServiceImpl<D, E, PK> service;

    @Autowired
    public void setService(AbstractBaseServiceImpl<D, E, PK> service) {
        this.service = service;
    }

    @GetMapping(ApiUri.EXISTS_BY_ID)
    public boolean existsById(@RequestParam("id") PK id) {
        return service.existsById(id);
    }

    @GetMapping(ApiUri.FIND_ALL)
    public List<D> findAll() {
        return service.findAll();
    }

    @GetMapping(ApiUri.FIND_BY_ID)
    public D findById(@RequestParam PK id) {
        return service.findById(id);
    }

}
