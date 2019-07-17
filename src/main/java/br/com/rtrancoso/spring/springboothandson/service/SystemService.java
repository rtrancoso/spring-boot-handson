package br.com.rtrancoso.spring.springboothandson.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rtrancoso.spring.springboothandson.entity.System;
import br.com.rtrancoso.spring.springboothandson.repository.SystemRepository;

@Service
public class SystemService {

	@Autowired
	private SystemRepository systemRepository;

	public System find( Long id ) {
		return systemRepository.findById( id ).orElseThrow( () -> new EntityNotFoundException() );
	}

	public List<System> findAll() {
		return ( List<System> ) systemRepository.findAll();
	}

	public System create( @Valid System system ) {
		return systemRepository.save( system );
	}

	public System update( Long id, @Valid System system ) {
		return systemRepository.save( system );
	}

	public void delete( Long id ) {
		systemRepository.deleteById( id );
	}

}
