package com.example.Alpha.mysql;

import org.springframework.data.repository.CrudRepository;

import com.example.Alpha.mysql.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    //public User findByUserId(String id);
}
