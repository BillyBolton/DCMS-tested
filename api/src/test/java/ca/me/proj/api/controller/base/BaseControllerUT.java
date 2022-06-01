package ca.me.proj.api.controller.base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import ca.me.proj.api.config.TestWebConfig;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public abstract class BaseControllerUT {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    protected TestWebConfig config;
}
