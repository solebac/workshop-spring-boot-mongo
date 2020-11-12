package com.erpro.worshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpro.worshopmongo.domain.Post;
import com.erpro.worshopmongo.domain.User;
import com.erpro.worshopmongo.dto.UserDTO;
import com.erpro.worshopmongo.exceptions.ObjectNotFoundException;
import com.erpro.worshopmongo.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repo;

	public List<Post> findAll() {
		return repo.findAll();
	}

	public Post findById(String Id) {
		Optional<Post> user = repo.findById(Id);
		if (user == null) {
			throw new ObjectNotFoundException("Object Invalid");
		}
		// return user.get();
		return user.orElseThrow(() -> new ObjectNotFoundException("Object Inserlid"));
	}
}
