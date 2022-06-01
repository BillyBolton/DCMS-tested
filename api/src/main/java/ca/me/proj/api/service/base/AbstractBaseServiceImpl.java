package ca.me.proj.api.service.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ca.me.proj.api.dtos.base.BaseDTO;
import ca.me.proj.api.dtos.exceptions.ResourceNotFoundException;
import ca.me.proj.api.entity.base.AbstractBaseEntity;
import ca.me.proj.api.mapper.base.IBaseMapper;
import ca.me.proj.api.repository.base.IBaseRepository;

public abstract class AbstractBaseServiceImpl<D extends BaseDTO, E extends AbstractBaseEntity, PK>
        implements IBaseService<D, PK> {

    @Autowired
    protected IBaseMapper<D, E> mapper;

    @Autowired
    protected IBaseRepository<E, PK> repository;

    public boolean existsById(PK id) {
        return repository.existsById(id);
    }


    public List<D> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public D findById(PK id) {
        if (!existsById(id)) {
            throw new ResourceNotFoundException("Entity with id: " + id + " not found");
        }
        return mapper.entityToDto(repository.findById(id).orElse(null));
    }

    public D save(D dto) {
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(dto)));
    }

    public List<D> save(Iterable<D> dto) {
        return mapper.entityToDto(repository.saveAll(mapper.dtoToEntity(dto)));
    }

    public D update(D dto) {
        // TODO: validation checks
        return this.save(dto);
    }

    public List<D> update(Iterable<D> dtos) {
        // TODO: validation checks
        return mapper.entityToDto(repository.saveAll(mapper.dtoToEntity(dtos)));
    }

    public boolean deleteById(PK id) {

        if (!existsById(id)) {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }

        repository.deleteById(id);
        boolean deleteSuccessful = !repository.existsById(id);
        return deleteSuccessful;
    }

}
