package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Service;
import static org.junit.Assert.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class ParchisServiceTest {
    @Autowired
    GameService gameService;

    @Autowired
    GameActionService gameActionService;

    @Autowired
    ParchisService parchisService;

    @Autowired
    PlayerService playerService;

    @Autowired
    BoardFieldService boardFieldService;



    //Check the Gameboard Init method
    @Test
    public void checkIfBoardIsCreated(){
        Game game = new Game();
        game.setName("test");
        //parchisService.initGameBoard(game);
        assertTrue(game.getGameBoard() != null);
    }

}
