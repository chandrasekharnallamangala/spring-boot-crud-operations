package com.crudproject.crudops;

import com.crudproject.crudops.Entities.User;
import com.crudproject.crudops.Repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests
{
    @Autowired private UserRepository userRepository;

    @Test
    public void testAddNew()
    {
        User user = new User();
        user.setEmail("chandu@gmail.com");
        user.setPassword("Chandu@123");
        user.setFirstName("chandra");
        user.setLastName("Sekhar");

        User savedUser = userRepository.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll()
    {
        Iterable<User> users = userRepository.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user : users)
        {
            System.out.println(user);
        }
    }

    @Test
    public void testUpdate()
    {
        Integer id = 1;
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        user.setPassword("Chandra@2001");
        userRepository.save(user);

        User updateUser = userRepository.findById(id).get();
        Assertions.assertThat(updateUser.getPassword()).isEqualTo("Chandra@2001");
    }

    @Test
    public void testGet()
    {
        Integer id = 1;
        Optional<User> optionalUser = userRepository.findById(id);
        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());
    }

    @Test
    public void testDelete()
    {
        Integer id = 2;
        userRepository.deleteById(id);

        Optional<User> optionalUser = userRepository.findById(id);
        Assertions.assertThat(optionalUser).isNotPresent();
    }



}
