package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE))
public class BoardfieldServiceTest {

    @Autowired
    BoardFieldService boardFieldService;

    @Autowired
    GameService gameService;

    @Test
    void saveAndFindBoardField() {

        Game game = new Game();
        game.setName("test");
        this.gameService.save(game);

        GameBoard gameBoard = new GameBoard();
        gameBoard.setWidth(800);
        gameBoard.setHeight(800);
        this.gameService.save(game);

        BoardField boardField = new BoardField();
        boardField.setGameBoard(gameBoard);
        this.boardFieldService.save(boardField);

        Assertions.assertNotNull(this.boardFieldService.find(1, gameBoard));
    }

    @Test
    void checkNextField() {
        Game game = new Game();
        game.setName("test");
        this.gameService.save(game);

        GameBoard gameBoard = new GameBoard();
        gameBoard.setWidth(800);
        gameBoard.setHeight(800);
        this.gameService.save(game);

        BoardField firstField = new BoardField();
        BoardField secondField = new BoardField();

        firstField.setGameBoard(gameBoard);
        this.boardFieldService.save(firstField);

        secondField.setGameBoard(gameBoard);
        this.boardFieldService.save(secondField);

        Assertions.assertTrue(this.boardFieldService.getNextBoardFieldByNumberBoard(1, gameBoard) == secondField);
    }
}
