package com.crudproject.crudops.Service;

import com.crudproject.crudops.Entities.User;
import com.crudproject.crudops.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired private UserRepository userRepository;

    public List<User> listAll()
    {
        return (List<User>) userRepository.findAll();

    }

    public void save(User user)
    {
        userRepository.save(user);
    }

    public User get(Integer id)throws UserNotFoundException
    {
        Optional<User> result = userRepository.findById(id);
        if(result.isPresent())
        {
            return result.get();
        }
        throw new UserNotFoundException("could not found any user by this ID"+id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = userRepository.countById(id);
        if(count == null || count == 0)
        {
            throw new UserNotFoundException("could not found any user by this ID"+id);
        }
        userRepository.deleteById(id);
    }
}
