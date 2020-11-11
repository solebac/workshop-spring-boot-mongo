package com.erpro.worshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erpro.worshopmongo.domain.User;
import com.erpro.worshopmongo.dto.UserDTO;
import com.erpro.worshopmongo.exceptions.ObjectNotFoundException;
import com.erpro.worshopmongo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	public User findById(String Id) {
		Optional<User> user = repo.findById(Id);
		if (user == null) {
			throw new ObjectNotFoundException("Object Invalid");
		}
		//return user.get();
		return user.orElseThrow(() -> new ObjectNotFoundException("Object Inserlid"));
	}
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public User fromDTO(UserDTO obj) {
		return new User(obj.getId(), obj.getName(), obj.getEmail());
	}
	public void delete(String id) {
		//Faz uma busca primeiro
		findById(id);
		repo.deleteById(id);
	}
}
