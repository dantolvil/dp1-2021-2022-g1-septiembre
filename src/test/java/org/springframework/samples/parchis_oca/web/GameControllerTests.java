package org.springframework.samples.parchis_oca.web;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.model.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.samples.parchis_oca.service.GameService;
import org.springframework.samples.parchis_oca.service.PlayerService;
import org.springframework.samples.parchis_oca.service.TurnService;
import org.springframework.samples.parchis_oca.web.GameController;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = GameController.class, includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE), excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class), excludeAutoConfiguration = SecurityAutoConfiguration.class)

public class GameControllerTests {


    @Autowired
    private GameController gameController;


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlayerService playerService;

    @MockBean
    private TurnService turnService;

    @MockBean
    private GameService gameService;

    private Optional<Game> createTestCreatedGame(){
       Game game = new Game();
       Player creator = createTestPlayer().get();

       game.setCreator(creator);
       game.setMaxPlayer(2);
       game.setName("newgame");
       game.setMaxPlayer(2);
       game.setCurrentPlayers(creator);

       game.setStatus(GameStatus.INITIED);

       return Optional.of(game);
    }

    private Optional<Player> createTestPlayer(){
      Player testPlayer = new Player();

      testPlayer.setFirstName("Dan");
      testPlayer.setLastName("Toledo");
      testPlayer.setEmail("dtv@web.es");
    
      Optional<Player> userOptional = Optional.of(testPlayer);
      return userOptional;
   }

   private List<Game> createTestGame(){
      List<Game> games = new ArrayList<>();
      return games;
   }

   @BeforeEach
   void init(){
      when(gameController.findAllCreatedGames())
         .thenReturn(createTestGame());

      when(playerService.getCurrentPlayer())
            .thenReturn(createTestPlayer());
   }


    @Test
    @WithMockUser(value = "player1")
    void testViewForCreateGame() throws Exception
    {
      mockMvc.perform(get("/game/create"))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(view().name("game/createGameForm"));


    }


    @Test
    @WithMockUser(value = "player1")
    void testViewForJoinGame() throws Exception
    {
      mockMvc.perform(get("/game/join"))
         .andDo(print())
         .andExpect(status().isOk())
         .andExpect(view().name("game/joinGameForm"));

    }

    @Test
    void testJoinGameShouldFail() throws Exception
    {

      mockMvc.perform(post("/game/join"))
          .andDo(print())
          .andExpect(status().isOk()) .andExpect(view().name("exception"));
    }

    @Test
    void testParchisGameJoin() throws Exception
    {

      Integer gameID = 1;
      when(gameService.findById(gameID))
         .thenReturn(createTestCreatedGame());


      mockMvc.perform(post("/game/join/Parchis/{gameID}", 1)
      .contentType(MediaType.APPLICATION_JSON)
      ).andDo(print());
    }


    @Test
    void testOcaGameJoin() throws Exception
    {


        Integer gameID = 1;
        when(gameService.findById(gameID))
            .thenReturn(createTestCreatedGame());

        mockMvc.perform(post("/game/join/Oca/{gameID}", 1)
                .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print());
    }







}
