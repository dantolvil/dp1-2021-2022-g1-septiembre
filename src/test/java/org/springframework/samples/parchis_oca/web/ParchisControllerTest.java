package org.springframework.samples.parchis_oca.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.parchis_oca.enums.GameOption;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.model.Player;
import org.springframework.samples.parchis_oca.service.GameActionService;
import org.springframework.samples.parchis_oca.service.GameService;
import org.springframework.samples.parchis_oca.service.ParchisService;
import org.springframework.samples.parchis_oca.service.PlayerService;
import org.springframework.samples.parchis_oca.web.ParchisController;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = ParchisController.class, includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = SecurityAutoConfiguration.class)

public class ParchisControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        ParchisService parchisService;

        @MockBean
        GameService gameService;

        @MockBean
        PlayerService playerService;

        @MockBean
        GameActionService gameActionService;


    private Optional<Game> createGame() {
        Game game = new Game();
        Player creator = new Player(); 
        game.setName("newGame");
        game.setStatus(GameStatus.INITIED);
        game.setCreator(creator);
        game.setGameOption(GameOption.PARCHIS);
        game.setId(1);
        game.setGameStarted(false);
        game.setMaxPlayer(2);
        game.setCurrentPlayers(creator);
        return Optional.of(game);
    }

    private Optional<Game> finishedGame() {
        Game game = new Game();
        Player creator = new Player();
        game.setName("new_game");
        game.setStatus(GameStatus.FINISHED);
       game.setCreator(creator);
        game.setGameOption(GameOption.PARCHIS);
        game.setId(1);
        game.setGameStarted(false);
        game.setMaxPlayer(2);
        game.setCurrentPlayers(creator);
        return Optional.of(game);
    }

    private Optional<Player> createTestUser(){
        Player testPlayer = new Player();
        testPlayer.setFirstName("Dan");
        testPlayer.setLastName("Dantol");
        testPlayer.setEmail("Dan@web.es");
        Optional<Player> playerOptional = Optional.of(testPlayer);
        return playerOptional;
     }


    @Test
    public void redirectToJoinParchisTest() throws Exception{

        when(this.gameService.findById(1)).thenReturn(createGame());
        mockMvc.perform(get("/game/parchis/1"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/game/parchis/join/1"));

    }

    @Test
    public void joinParchisGame() throws Exception{

        when(gameService.findById(1)).thenReturn(createGame());

        when(playerService.getCurrentPlayer()).thenReturn(createTestUser());

        mockMvc.perform(get("/game/parchis/join/{gameid}", 1))
            .andDo(print())
            .andExpect(status().isOk());
    }

    @Test
    public void joinParchisGameTestShouldThrowException() throws Exception{

        when(gameService.findById(1)).thenReturn(createGame());
        mockMvc.perform(get("/game/parchis/join/{gameid}", 1))
            .andDo(print())
           .andExpect(status().isOk())
            .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof NoSuchElementException));
    }


    @Test
public void exitGameTest() throws Exception {


        when(this.gameService.findById(1)).thenReturn(finishedGame());
        mockMvc.perform(get("/game/parchis/join/1/quit"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/"));
    }

    @Test
    public void throwDiceGameTest() throws Exception {


        when(this.gameService.findById(1)).thenReturn(createGame());

        mockMvc.perform(get("/game/parchis/join/1/dice"))
                        .andDo(print())
                        .andExpect(status().is3xxRedirection())
                        .andExpect(view().name("redirect:/game/parchis/join/1"));
    }


}
