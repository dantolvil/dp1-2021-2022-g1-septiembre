package org.springframework.samples.parchis_oca.service;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.service.GameService;
import org.springframework.samples.parchis_oca.service.PlayerService;
import org.springframework.stereotype.Service;
import javax.persistence.Transient;
import java.util.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class GameServiceTests {

   @Autowired
   GameService gameService;

   @Autowired
   PlayerService playerService;

    @Transient
    private static final Logger logger = LoggerFactory.getLogger(GameServiceTests.class);

    @Test
    public void findAndSaveGame() throws InterruptedException {
        Game game = new Game();
        game.setName("test");

        try {
            gameService.save(null, game);
        } catch (Exception e) {
        }

        @SuppressWarnings("unused")
		Optional<Game> optionalGame = gameService.findById(1);
        Assertions.assertNotNull(this.gameService.findById(1));

    }

    @Test
    public void searchForNonExistingGame() throws InterruptedException {

        Game game1 = new Game();
        game1.setName("notExist");

        Assertions.assertFalse(this.gameService.gameNameExists(game1));
    }

}
