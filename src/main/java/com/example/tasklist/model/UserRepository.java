package com.example.tasklist.model;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Long>{
    User findByName(String name);
}
