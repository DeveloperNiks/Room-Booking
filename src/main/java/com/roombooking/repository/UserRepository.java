package com.roombooking.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.roombooking.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

}
