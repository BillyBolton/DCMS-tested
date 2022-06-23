package ca.me.proj.api.controller.base;

import java.util.List;
import ca.me.proj.api.dtos.base.BaseDTO;

public interface IReadController<D extends BaseDTO, PK> {

    public abstract boolean existsById(PK id);

    public abstract List<D> findAll();

    public abstract D findById(PK entityId);

}
