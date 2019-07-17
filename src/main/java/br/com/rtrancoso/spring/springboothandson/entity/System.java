package br.com.rtrancoso.spring.springboothandson.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class System {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;

	@NotNull( message = "É necessário informar o nome." )
	@Column( nullable = false )
	private String name;

	@Column( name = "created_at" )
	private LocalDateTime createdAt;

	@PrePersist
	void prePersist() {
		if( createdAt == null ) {
			createdAt = LocalDateTime.now();
		}
	}

}
