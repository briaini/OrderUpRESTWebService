package com.cs4125.OrderUpRESTWebService.repositories;

import com.cs4125.OrderUpRESTWebService.models.RestaurantUser;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantUserRepository extends CrudRepository<RestaurantUser, Integer> {
}