package ca.me.proj.api.controller.base;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ca.me.proj.api.constants.ApiUri;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.entity.base.AbstractBaseEntity;

public abstract class AbstractCrudController<D extends BaseDTO, E extends AbstractBaseEntity, PK>
        extends AbstractReadController<D, E, PK> {

    @PostMapping(ApiUri.SAVE)
    public D save(@RequestBody D dto) {
        return service.save(dto);
    }

    @PutMapping(ApiUri.SAVE)
    public D update(@RequestBody D dto) {
        return service.update(dto);
    }

    @DeleteMapping(ApiUri.DELETE)
    public boolean deleteById(@RequestParam PK id) {
        return service.deleteById(id);
    }

}
