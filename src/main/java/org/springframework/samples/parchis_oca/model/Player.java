package org.springframework.samples.parchis_oca.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "players")
public class Player extends Person {

	//Attributes
	
	@Column(name = "email")
	@NotBlank
	private String email;

	//Relationships
	@OneToMany(cascade = CascadeType.ALL)
	private List<Turn> turn;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gamePiece")
	private GamePiece gamePiece;

	public boolean checkAlreadyCreatedGames() {

		return false;
	}
	
}
