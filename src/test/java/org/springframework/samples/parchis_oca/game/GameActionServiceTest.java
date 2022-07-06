package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class GameActionServiceTest {

    @Autowired
    GameActionService gameActionService;

    @Test
    void shouldSaveNewOption()
    {
        GameAction gameAction = new GameAction();
        this.gameActionService.save(gameAction);

        Optional<GameAction> optionalGameAction = this.gameActionService.findGameActionByAction("thisIsAGameAction");
        assertTrue(optionalGameAction.isPresent());
        assertEquals(optionalGameAction.get().getAction(), "thisIsAGameAction");
        assertEquals((int) optionalGameAction.get().getActionNumber(), 12);
    }

    @Test
    void shouldNotFindNonExistingOption()
    {
        Optional<GameAction> optionalGameAction = this.gameActionService.findGameActionByAction("thisIsNotAGameAction");
        assertFalse(optionalGameAction.isPresent());
    }
}
