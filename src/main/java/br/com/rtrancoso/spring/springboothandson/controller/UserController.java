package br.com.rtrancoso.spring.springboothandson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.rtrancoso.spring.springboothandson.entity.User;
import br.com.rtrancoso.spring.springboothandson.service.UserService;

@RestController
@RequestMapping( "/users" )
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping( value = "/{id}" )
	public User find( @PathVariable( "id" ) Long id ) {
		return userService.find( id );
	}

	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public User create( @RequestBody User user ) {
		return userService.create( user );
	}

	@PutMapping( value = "/{id}" )
	@ResponseStatus( HttpStatus.OK )
	public void update( @PathVariable( "id" ) Long id, @RequestBody User user ) {
		userService.update( id, user );
	}

	@DeleteMapping( value = "/{id}" )
	@ResponseStatus( HttpStatus.OK )
	public void delete( @PathVariable( "id" ) Long id ) {
		userService.delete( id );
	}

}
