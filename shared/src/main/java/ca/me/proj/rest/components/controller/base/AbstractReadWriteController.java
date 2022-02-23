package ca.me.proj.rest.components.controller.base;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ca.me.proj.rest.components.constants.ApiUri;
import ca.me.proj.rest.components.dtos.base.BaseDTO;
import ca.me.proj.rest.components.entity.base.AbstractBaseEntity;

public abstract class AbstractReadWriteController<D extends BaseDTO, E extends AbstractBaseEntity>
        extends AbstractReadController<D, E> {

    @PostMapping(ApiUri.SAVE)
    public D save(@RequestBody D dto) {
        return service.save(dto);
    }

    @PutMapping(ApiUri.SAVE)
    public D update(@RequestBody D dto) {
        return service.update(dto);
    }

    @DeleteMapping(ApiUri.DELETE)
    public boolean delete(@RequestParam long id) {
        return service.delete(id);
    }

}
