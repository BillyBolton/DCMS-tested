package ca.me.proj.api.repository.base;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<E, PK> extends CrudRepository<E, PK> {

}
