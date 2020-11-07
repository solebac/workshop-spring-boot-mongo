package com.erpro.worshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.erpro.worshopmongo.domain.User;
import com.erpro.worshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	/*Step-01
	 * 
	@RequestMapping(method = RequestMethod.GET)
	public List<User> findAll(){
		User maria = new User("1", "Maria VBrow da silava", "flavio@flavio.com");
		User flavio = new User("1", "Flavio Rogerio da silava", "maria@maria.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, flavio));
		return list;
	}
	*/
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
