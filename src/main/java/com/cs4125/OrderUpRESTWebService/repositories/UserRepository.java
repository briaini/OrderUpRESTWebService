package com.cs4125.OrderUpRESTWebService.repositories;

import com.cs4125.OrderUpRESTWebService.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByUsername(@Param("username") String username);
}