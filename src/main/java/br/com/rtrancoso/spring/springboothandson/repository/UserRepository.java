package br.com.rtrancoso.spring.springboothandson.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.rtrancoso.spring.springboothandson.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail( String email );

}
