package com.store.digital.supermarket.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.store.digital.supermarket.domain.Role;
import com.store.digital.supermarket.domain.User;

import org.junit.jupiter.api.*;

import java.util.Map;

class UserRepositoryTest {

    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
    }

    @Test
    void saveUserIntoTheUserRepo() {
        //given user is created
        User user = new User();
        user.setUsername("leonard007");
        user.setFirstname("Kelvin");
        user.setLastname("Leo");
        user.setRole(Role.EMPLOYEE);

        // then user can be saved
        userRepository.save(user);
        Map<Long, User> users = userRepository.getAllUsers();
        assertTrue(users.containsKey(1L));
        assertEquals(users.get(1L), user);
        assertTrue(users.size() != 0);

    }
}