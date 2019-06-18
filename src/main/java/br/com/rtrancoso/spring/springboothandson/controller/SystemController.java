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

import br.com.rtrancoso.spring.springboothandson.entity.System;
import br.com.rtrancoso.spring.springboothandson.service.SystemService;

@RestController
@RequestMapping( "/systems" )
public class SystemController {

	@Autowired
	private SystemService systemService;

	@GetMapping( value = "/{id}" )
	public System find( @PathVariable( "id" ) Long id ) {
		return systemService.find( id );
	}

	@GetMapping
	public List<System> findAll() {
		return systemService.findAll();
	}

	@PostMapping
	@ResponseStatus( HttpStatus.CREATED )
	public System create( @RequestBody System system ) {
		return systemService.create( system );
	}

	@PutMapping( value = "/{id}" )
	@ResponseStatus( HttpStatus.OK )
	public void update( @PathVariable( "id" ) Long id, @RequestBody System system ) {
		systemService.update( id, system );
	}

	@DeleteMapping( value = "/{id}" )
	@ResponseStatus( HttpStatus.OK )
	public void delete( @PathVariable( "id" ) Long id ) {
		systemService.delete( id );
	}

}
