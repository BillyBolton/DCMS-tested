package ca.me.proj.api.controller.base;

import java.util.List;
import ca.me.proj.api.dtos.base.BaseDTO;

public interface ICrudController<D extends BaseDTO, PK> extends IReadController<D, PK> {

    public abstract D save(D dto);

    public abstract List<D> save(Iterable<D> dtos);

    public abstract D update(D dto);

    public abstract List<D> update(Iterable<D> dtos);

    public abstract boolean deleteById(PK id);

}
