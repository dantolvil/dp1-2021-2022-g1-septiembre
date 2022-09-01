package org.springframework.samples.parchis_oca.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "boardFields")
public class BoardField extends BaseEntity{
	
	//Attributes
	
	private int number;
	
	//Relationships
	
    @ManyToOne()
    private GameBoard gameBoard;
    
    @OneToOne
    public BoardField nextBoardField;

}
