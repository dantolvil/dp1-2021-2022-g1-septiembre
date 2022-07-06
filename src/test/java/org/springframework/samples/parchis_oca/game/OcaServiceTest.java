package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.enums.GameBox;
import org.springframework.samples.parchis_oca.enums.GameOption;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Service;
import java.awt.*;
import java.util.*;
import static org.junit.Assert.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))

public class OcaServiceTest {

    private static final int OCA_NUMBER_OF_FIELDS = 64;

    @Autowired
    OcaService ocaService;
    
    @Autowired
    GameService gameService;
    
    @Autowired
    PlayerService playerService;
   
    @Autowired
    BoardFieldService boardFieldService;

    @Test
    void initGameBoardAndCheckNumberOfFields()
    {
        Game game = new Game();
        game.setName("test");
        this.gameService.save(game);

        GameBoard gameBoard = game.getGameBoard();
        //assertTrue(gameBoard.getBoardFields().size() == OCA_NUMBER_OF_FIELDS);

    }


    @Test
    void checkPieceMoving()
    {
        Game game = new Game();
        game.setName("test");
        Optional<Player> optionalPlayer = this.playerService.findPlayer("player");
        Player foundUser = optionalPlayer.get();
        game.setCurrentPlayers(foundUser);
        game.setGameOption(GameOption.OCA);

        this.gameService.save(game);

    }

    @Test
    void checkGooseToGoose()
    {
        Game game = new Game();
        game.setName("test");
        Optional<Player> optionalPlayer = this.playerService.findPlayer("player");
        Player foundUser = optionalPlayer.get();
        game.setCurrentPlayer(foundUser);
        game.setGameOption(GameOption.OCA);
        game.getCurrentPlayer().getGamePiece().setBoardField(boardFieldService.find(0, game.getGameBoard()));
        this.gameService.save(game);


        GamePiece piece = game.getCurrentPlayer().getGamePiece();
        piece.setBoardField(boardFieldService.find(1, game.getGameBoard()));
        Assertions.assertTrue(piece.getBoardField().getGameBoard().equals(GameBox.GOOSE) && piece.getBoardField().getNextBoardField().getGameBoard().equals(GameBox.GOOSE));

    }


}
