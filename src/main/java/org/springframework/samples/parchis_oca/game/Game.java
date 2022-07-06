package org.springframework.samples.parchis_oca.game;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.samples.parchis_oca.enums.GameMovement;
import org.springframework.samples.parchis_oca.enums.GameOption;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.model.NamedEntity;
import org.springframework.samples.parchis_oca.player.Player;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "games")
public class Game extends NamedEntity {
	
    @Transient
    private static final Logger logger = LogManager.getLogger(Game.class);
	   
	//Attributes

    @NotEmpty
    private String name;

    private int maxPlayer;

    @ElementCollection
    private List<String> historyBoard;

    private boolean gameStarted = false;
    
    //Enumerates
    
    @Enumerated(EnumType.STRING)
    private GameStatus status;

    @Enumerated(EnumType.STRING)
    private GameOption gameOption;  
    
    @Enumerated(EnumType.STRING)
    private GameMovement gameMovement = GameMovement.START;
    
    //Relationships

    @ManyToOne()
    @JoinColumn(name = "username")
    private Player creator;
    
    @OneToOne
    private Player currentPlayer;
    
    @ManyToOne()
    private Player winner;

    @OneToOne(cascade = CascadeType.ALL)
    private GameBoard gameBoard;

    @ManyToMany
    private List <Player> currentPlayers;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Turn> turns;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime startTime;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime endTime;
    
    //Methods
    
    public void addTurn(Turn turn) {
        if (turns == null)
            turns = new ArrayList <> ();

        turns.add(turn);

    }

    public boolean checkMaxAmountPlayers() {
        logger.info(this.getCurrentPlayers());
        return this.getCurrentPlayers().size() < maxPlayer;
    }

    public void setCurrentPlayers(Player player) {
        currentPlayers = new ArrayList < > ();
        logger.info("Current players.size before" + currentPlayers.size());
        currentPlayers.add(player);
        logger.info("Current players.size" + currentPlayers.size());
    }
    
    public void setTurns(Turn turn){
        turns = new ArrayList<>();
        turns.add(turn);
    }
 
}
