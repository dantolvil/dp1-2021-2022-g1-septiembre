package org.springframework.samples.parchis_oca.model;

import java.awt.Color;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "gamePieces")
public class GamePiece extends BaseEntity{

	
	//Attributes
	
	private Color pieceColor;
	
    //Relationships

    @ManyToOne
    @JoinColumn(name = "boardField")
    BoardField boardField;

    @ManyToOne()
    @JoinColumn(name = "player")
    private Player player;


}