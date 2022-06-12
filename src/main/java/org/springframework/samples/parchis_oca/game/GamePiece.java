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
@Table(name = "gamePieces")
public class GamePiece extends BaseEntity{



    @ManyToOne
    @JoinColumn(name = "boardField")
    BoardField boardField;

    @ManyToOne()
    @JoinColumn(name = "player")
    private Player player;



}