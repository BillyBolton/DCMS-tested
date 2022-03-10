package ca.me.proj.service.base;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ca.me.proj.dtos.base.BaseDTO;
import ca.me.proj.entity.base.AbstractBaseEntity;
import ca.me.proj.exceptions.ResourceNotFoundException;
import ca.me.proj.mapper.base.IBaseMapper;
import ca.me.proj.repository.base.IBaseRepository;

public abstract class AbstractBaseServiceImpl<D extends BaseDTO, E extends AbstractBaseEntity>
        implements IBaseService<D> {

    @Autowired
    protected IBaseRepository<E> repository;

    @Autowired
    protected IBaseMapper<D, E> mapper;

    public boolean existsById(long id) {
        return repository.existsById(id);
    }

    public List<D> findAll() {
        return mapper.entityToDto(repository.findAll());
    }

    public D findById(long id) {
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

    public boolean delete(long id) {

        // TODO: Look at better validation processes
        if (id <= 0) {
            throw new ResourceNotFoundException("An entity id must be greater than " + 0);
        }

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found with id " + id);
        }

        repository.deleteById(id);
        boolean deleteSuccessful = !repository.existsById(id);
        return deleteSuccessful;
    }

}
