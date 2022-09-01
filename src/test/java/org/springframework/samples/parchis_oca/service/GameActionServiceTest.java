package org.springframework.samples.parchis_oca.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.model.GameAction;
import org.springframework.samples.parchis_oca.service.GameActionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.junit.Assert.*;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class),
    excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class GameActionServiceTest {

    @Autowired
    GameActionService gameActionService;

    @Test
    void findAndSaveGameAction(){
    	
        GameAction gameAction = new GameAction();
        gameAction.setAction("test");
        gameAction.setActionChoose(true);
        gameAction.setActionNumber(1);
        this.gameActionService.save(gameAction);

        Assertions.assertNotNull(this.gameActionService.findById(1));

    }

    @Test
    void shouldNotFindOrNonExistingGameAction(){
    	
        Optional<GameAction> optionalGameAction = this.gameActionService.findGameActionByAction("thisIsNotAGameAction");
        assertFalse(optionalGameAction.isPresent());
    }
}
