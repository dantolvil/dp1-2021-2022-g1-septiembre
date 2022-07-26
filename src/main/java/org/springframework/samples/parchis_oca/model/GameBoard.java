package org.springframework.samples.parchis_oca.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gameBoards")
public class GameBoard  extends BaseEntity {
	
	//Attributes
	
    @Positive
    int width;
    @Positive
    int height;

	//Relationships
	
    @OneToMany
	private List<GameAction> gameActions;
	 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "game")
    Game game;
    
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "board")
	private List<BoardField> boardField;

	public Object getBoardFields() {
		// TODO Auto-generated method stub
		return null;
	}


}
