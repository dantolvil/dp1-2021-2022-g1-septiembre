package org.springframework.samples.parchis_oca.game;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.samples.parchis_oca.model.BaseEntity;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "boardFields")
public class BoardField extends BaseEntity{
	
    @ManyToOne()
    @JoinColumn(name = "gameBoard")
    private GameBoard gameBoard;

}
