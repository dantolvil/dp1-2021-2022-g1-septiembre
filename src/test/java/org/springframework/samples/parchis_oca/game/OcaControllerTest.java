package org.springframework.samples.parchis_oca.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.enums.GameMovement;
import org.springframework.samples.parchis_oca.enums.GameOption;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = OcaController.class, includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = SecurityAutoConfiguration.class)

public class OcaControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        OcaService ocaService;

        @MockBean
        GameService gameService;

        @MockBean
        PlayerService playerService;

        @MockBean
        GameActionService gameActionService;


    private Optional<Game> createGame() {
        Game game = new Game();
        game.setId(1);
        Player creator = new Player();//createTestUser().get();
        game.setName("newGame");
        game.setStatus(GameStatus.INITIED);
        game.setCreator(creator);
        game.setGameOption(GameOption.OCA);
        game.setId(1);
        game.setGameStarted(false);
        game.setCurrentPlayers(creator);
        return Optional.of(game);
    }

    private Optional<Game> finishedGame() {
        Game game = new Game();
        Player creator = new Player(); //createTestUser().get();
        game.setName("newGame");
        game.setStatus(GameStatus.FINISHED);
        game.setCreator(creator);
        game.setGameOption(GameOption.OCA);
        game.setId(1);
        game.setGameStarted(false);
        game.setCurrentPlayers(creator);
        return Optional.of(game);
    }

    private Optional<Player> createTestUser(){
        Player testPlayer = new Player();
        GamePiece gamePiece = new GamePiece();
        gamePiece.setBoardField(new BoardField());
        testPlayer.setFirstName("Fran");
        testPlayer.setLastName("Rodríguez");
        testPlayer.setEmail("fr@web.de");
        Optional<Player> playerOptional = Optional.of(testPlayer);
        return playerOptional;
     }

     private Optional<GameAction> createTestChoice(){
        GameAction testGameAction = new GameAction();
        testGameAction.setId(1);
        testGameAction.setActionNumber(2);
        //testGameAction.setAction(GameMovement.MOVEMENT);
        Optional<GameAction> gameActionOptional = Optional.of(testGameAction);
        return gameActionOptional;
     }


    @Test
    public void redirectToJoinTest() throws Exception{

        when(this.gameService.findById(1)).thenReturn(createGame());
        mockMvc.perform(get("/game/oca/1"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/game/oca/join/1"));

    }


    @Test
    public void joinOca() throws Exception{

        when(gameService.findById(1)).thenReturn(createGame());
        when(playerService.getCurrentPlayer()).thenReturn(createTestUser());

        mockMvc.perform(get("/game/oca/join/{gameid}", 1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("game/ocaGame"));
    }

    @Test
    public void joinOcaTestShouldThrowException() throws Exception{

        when(gameService.findById(1)).thenReturn(createGame());
        mockMvc.perform(get("/game/oca/join/{gameid}", 1))
            .andDo(print())
           .andExpect(status().isOk())
            .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof NoSuchElementException));
    }

    @Test
public void quitGameTest() throws Exception {


        when(this.gameService.findById(1)).thenReturn(finishedGame());
        mockMvc.perform(get("/game/oca/join/1/quit"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/"));
    }

    @Test
public void diceGameTest() throws Exception {


        when(this.gameService.findById(1)).thenReturn(createGame());

        mockMvc.perform(get("/game/oca/join/1/dice"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/game/oca/join/1"));
    }

    @Test

public void choiceGameTest() throws Exception {

        when(this.gameService.findById(1)).thenReturn(createGame());
        //when(this.gameActionService.findOption(1)).thenReturn(createTestChoice());

        mockMvc.perform(get("/game/oca/join/1/choice/1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(result -> Assertions.assertFalse(result.getResolvedException() instanceof NoSuchElementException));
    }


}
