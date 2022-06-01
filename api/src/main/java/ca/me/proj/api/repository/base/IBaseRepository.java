package ca.me.proj.api.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<E, PK> extends JpaRepository<E, PK> {

}
