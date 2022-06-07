package ca.me.proj.api.integration.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ca.me.proj.api.entity.profile.ProfileEntity;
import ca.me.proj.api.integration.base.ITAbstract;
import ca.me.proj.api.repository.profile.IProfileRepository;
import lombok.extern.slf4j.Slf4j;

// https://www.arhohuttunen.com/spring-boot-datajpatest/

@Slf4j
@DataJpaTest
class ITProfileRepository extends ITAbstract {

    @Autowired
    private IProfileRepository repository;

    @Test
    void givenEntityExists_whenSearchingByValidProfile_returnEntity() {
        String id = "P_1";
        ProfileEntity entity = repository.findById(id).orElse(null);
        assertNotNull(entity);
        assertEquals(entity.getId(), id);
    }

}
