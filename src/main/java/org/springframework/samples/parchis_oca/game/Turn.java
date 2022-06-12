package org.springframework.samples.parchis_oca.game;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.samples.parchis_oca.model.BaseEntity;
import org.springframework.samples.parchis_oca.player.Player;

import lombok.Getter;
import lombok.Setter;

	@Getter
	@Setter
	@Entity
	@Table(name = "turns")
	public class Turn extends BaseEntity{

		//Attributes
		
	    private Integer number;

	    //Relationships
	    
	    @ManyToOne
	    @JoinColumn(name = "playerId")
	    private Player playerId;
	    
	}

