package com.erpro.worshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erpro.worshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
