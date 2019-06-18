package br.com.rtrancoso.spring.springboothandson.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rtrancoso.spring.springboothandson.entity.User;
import br.com.rtrancoso.spring.springboothandson.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User find( Long id ) {
		return userRepository.findById( id ).orElse( null );
	}

	public List<User> findAll() {
		return ( List<User> ) userRepository.findAll();
	}

	public User create( User system ) {
		return userRepository.save( system );
	}

	public User update( Long id, User system ) {
		return userRepository.save( system );
	}

	public void delete( Long id ) {
		userRepository.deleteById( id );
	}

}
