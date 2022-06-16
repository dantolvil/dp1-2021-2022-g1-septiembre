package org.springframework.samples.parchis_oca.game;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.samples.parchis_oca.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gameActions")
public class GameAction extends BaseEntity {

	//Attributes:
	
	@NotBlank
	private String action;
	
	@NotNull
	private Integer actionNumber;
	
	private boolean actionChoose = false;
	
	//Relationships:
	
	@ManyToOne()
	public GameBoard gameBoard;


}
