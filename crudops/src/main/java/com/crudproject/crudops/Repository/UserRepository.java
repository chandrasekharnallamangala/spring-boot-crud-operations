package com.crudproject.crudops.Repository;

import com.crudproject.crudops.Entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer>
{
    public Long countById(Integer id);
}
