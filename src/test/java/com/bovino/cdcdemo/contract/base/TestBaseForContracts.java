package com.bovino.cdcdemo.contract.base;

import com.bovino.cdcdemo.controller.UserController;
import com.bovino.cdcdemo.domain.User;
import com.bovino.cdcdemo.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
abstract class TestBaseForContracts {

    @Autowired
    UserController userController;

    @MockBean
    UserService userService;

    @Before
    public void setup() {

        StandaloneMockMvcBuilder standaloneMockMvcBuilder = MockMvcBuilders.standaloneSetup(userController);
        RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);

        // se quiser mocar services (melhor, pra nao ir no BD real)
        // se comentar daqui pra baixo, vai chamar o service real
        User newUser = new User();
        newUser.setId(1);
        newUser.setLogin("new login 1");
        newUser.setName("new username 1");
        Mockito.when(userService.saveNewUser(any(User.class)))
               .thenAnswer(i -> i.getArguments()[0]);

        User getByIdUser = new User();
        getByIdUser.setId(10);
        getByIdUser.setLogin("login test 10");
        getByIdUser.setName("name test 10");

        Mockito.when(userService.getUserById(10))
                .thenReturn(getByIdUser);

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

        Mockito.when(userService.getAllUsers())
                .thenReturn(userList);

    }
}