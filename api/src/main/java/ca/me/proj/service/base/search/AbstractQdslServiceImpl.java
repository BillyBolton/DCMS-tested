package ca.me.proj.service.base.search;

import java.util.List;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import ca.me.proj.dtos.base.BaseDTO;
import ca.me.proj.entity.base.AbstractBaseEntity;
import ca.me.proj.repository.base.IQdslRepository;
import ca.me.proj.service.base.AbstractBaseServiceImpl;

public abstract class AbstractQdslServiceImpl<D extends BaseDTO, E extends AbstractBaseEntity>
        extends AbstractBaseServiceImpl<D, E> implements IQdslService<D> {

    @Autowired
    protected IQdslRepository<E> repository;

    public List<D> search(BooleanBuilder expressions) {
        return mapper.entityToDto(repository.findAll(expressions));
    }

    public List<D> search(BooleanBuilder expressions, int page, int size) {
        return mapper.entityToDto(repository.findAll(expressions, PageRequest.of(page, size)));
    }

}

