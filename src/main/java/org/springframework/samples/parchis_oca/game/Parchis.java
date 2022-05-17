package org.springframework.samples.parchis_oca.game;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Parchis extends GameBoard {
    
	@Id
    private Integer id;

}
