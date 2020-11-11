package com.erpro.worshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.erpro.worshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
