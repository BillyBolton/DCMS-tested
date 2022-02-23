package ca.me.proj.rest.components.service.base.search;

import java.util.List;
import com.querydsl.core.BooleanBuilder;
import ca.me.proj.rest.components.dtos.base.BaseDTO;
import ca.me.proj.rest.components.service.base.IBaseService;

public interface IQdslService<D extends BaseDTO> extends IBaseService<D> {

    public abstract List<D> search(BooleanBuilder expressions);

    public abstract List<D> search(BooleanBuilder expressions, int page, int size);
}
