package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Service;
import java.util.Optional;
import static org.junit.Assert.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class TurnServiceTest {

    @Autowired
    TurnService turnService;

    @Autowired
    PlayerService playerService;

    @Test
    void shouldSaveNewTurn()
    {
        Turn turn = new Turn();
        turn.setNumber(4);

        Optional<Player> optionalPlayer = this.playerService.findPlayer("player1");

        if(optionalPlayer.isEmpty())
            Assertions.fail("Player does not exist ");

        this.turnService.saveTurn(turn);

        Optional<Turn> optionalTurn = this.turnService.findTurn(1);
        assertTrue(optionalTurn.isPresent());

        assertEquals((int) optionalTurn.get().getNumber(), 4);
    }

    @Test
    void shouldNotFindNonExistingTurn()
    {
        Optional<Player> optionalPlayer = this.playerService.findPlayer("player1");

        if(optionalPlayer.isEmpty())
            Assertions.fail("Player does not exist ");


        Optional<Turn> optionalTurn = this.turnService.findTurn(1);
        assertFalse(optionalTurn.isPresent());
    }
}
