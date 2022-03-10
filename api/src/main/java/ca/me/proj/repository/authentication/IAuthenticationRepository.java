package ca.me.proj.repository.authentication;

import org.springframework.stereotype.Repository;
import ca.me.proj.entity.authentication.AuthenticationEntity;
import ca.me.proj.repository.base.IBaseRepository;

@Repository
public interface IAuthenticationRepository extends IBaseRepository<AuthenticationEntity> {

}
