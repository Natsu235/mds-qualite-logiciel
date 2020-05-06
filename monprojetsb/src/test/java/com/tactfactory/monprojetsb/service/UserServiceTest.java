package com.tactfactory.monprojetsb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.MonprojetsbApplicationTests;
import com.tactfactory.monprojetsb.entity.User;
import com.tactfactory.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.repository.UserRepository;
import com.tactfactory.monprojetsb.repository.mock.MockitoUserRepository;
import com.tactfactory.monprojetsb.service.UserService;

//@RunWith(SpringRunner.class)
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@DataJpaTest
//@EntityScan(basePackages="com.tactfactory.monprojetsb")
//@ComponentScan(basePackages="com.tactfactory.monprojetsb")
@ActiveProfiles("test")
@TestPropertySource(locations = { "classpath:application-test.properties" })
@SpringBootTest(classes = MonprojetsbApplicationTests.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    //@Autowired
    //private UserRepository userRepository;

    //@Autowired
    //private ProductRepository productRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private ProductRepository productRepository;

    private User user;

    @BeforeEach
    public void setUp() throws Exception {
        final MockitoUserRepository userMock = new MockitoUserRepository(this.userRepository);
        userMock.init();
        this.user = userMock.user;
    }

    // Initialise la base avant chaque test
    //@Before
    //public void clear() {
    //    this.productRepository.deleteAll();
    //    this.userRepository.deleteAll();
    //}

    // Test l'incrémentation lors de l'ajout d'un utilisateur
    @Test
    public void TestInsertOne() {
        Long before = userRepository.count();
        userService.save(new User());
        Long after = userRepository.count();

        assertEquals(before + 1, after);
	}

    // Test la décrémentation lors de la suppression d'un utilisateur
    @Test
    public void TestDeleteOne() {
        User user = new User();
        userService.save(user);
        Long before = userRepository.count();
        userService.delete(user);
        Long after = userRepository.count();

        assertEquals(before - 1, after);
    }

}
