package br.com.rtrancoso.spring.springboothandson.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table( name = "users" )
public class User {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@NotNull( message = "É necessário informar o nome." )
	@Column( nullable = false )
	private String name;

	@NotNull( message = "É necessário informar o email." )
	@Column( nullable = false, unique = true )
	private String email;

	@NotNull( message = "É necessário informar uma senha." )
	@Column( nullable = false )
	private String password;

	@Column( name = "created_at" )
	private LocalDateTime createdAt;

	@PrePersist
	void prePersist() {
		if( createdAt == null ) {
			createdAt = LocalDateTime.now();
		}
	}

}
