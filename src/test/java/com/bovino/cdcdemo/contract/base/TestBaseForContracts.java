package com.bovino.cdcdemo.contract.base;

import com.bovino.cdcdemo.domain.User;
import com.bovino.cdcdemo.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestBaseForContracts {

    @Spy
    UserService userService;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {

        // StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(new UserController());
        // RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
        MockitoAnnotations.initMocks(this);
        RestAssuredMockMvc.webAppContextSetup(this.context);

        // se quiser mocar services (melhor, pra nao ir no BD real)
        // Uso do Spy, vou alterar apenas "getAllUsers()", os demais usam a impl padrao da classe
        List<User> userList = new ArrayList<>();
        User u1 = new User();
        u1.setId(1);
        u1.setLogin("login 1");
        u1.setName("name 1");

        User u2 = new User();
        u2.setId(2);
        u2.setLogin("login 2");
        u2.setName("name 2");

        userList.add(u1);
        userList.add(u2);

        Mockito.when(userService.getAllUsers()).thenReturn(userList);
    }
}