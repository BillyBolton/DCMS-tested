package ca.me.proj.rest.components.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<E> extends JpaRepository<E, Long> {

}
