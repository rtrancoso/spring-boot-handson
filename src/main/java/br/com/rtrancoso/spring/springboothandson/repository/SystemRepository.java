package br.com.rtrancoso.spring.springboothandson.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rtrancoso.spring.springboothandson.entity.System;

public interface SystemRepository extends CrudRepository<System, Long> {

	System findByName( String name );

}
