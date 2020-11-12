package com.erpro.worshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.erpro.worshopmongo.domain.Post;
import com.erpro.worshopmongo.domain.User;
import com.erpro.worshopmongo.dto.AuthorDTO;
import com.erpro.worshopmongo.dto.CommentDTO;
import com.erpro.worshopmongo.repository.PostRepository;
import com.erpro.worshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		userRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		postRepository.deleteAll();
		//Post post1 = new Post(null, sdf.parse("11/11/2020"), "Partiu viagem I", "De ferias para roça.", maria);
		//Post post2 = new Post(null, sdf.parse("10/11/2020"), "Partiu viagem II", "De ferias para Araxá.", maria);
		Post post1 = new Post(null, sdf.parse("11/11/2020"), "Partiu viagem I", "De ferias para roça.", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("10/11/2020"), "Partiu viagem II", "De ferias para Araxá.", new AuthorDTO(maria));
	
		//Insert Comentarios
		CommentDTO c1 = new CommentDTO("Boa dia mano!", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveite!", sdf.parse("21/03/2020"), new AuthorDTO(alex));
		CommentDTO c3 = new CommentDTO("How are you!", sdf.parse("21/03/2020"), new AuthorDTO(bob));
		//Association
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		
		//Recurso aninhado
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		//Recurso referencia
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);
		
	}

}
