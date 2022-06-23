package org.springframework.samples.parchis_oca.game;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.parchis_oca.enums.GameOption;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game")
public class GameController {

    private static final Logger logger = LoggerFactory.getLogger(GameController.class);
    private static final String VIEWS_GAME_CREATE_FORM = "game/createGameForm";
    private static final String VIEWS_GAME_PARCHIS = "game/parchis/";
    private static final String VIEWS_GAME_OCA = "game/oca/";
    private static final String VIEWS_JOIN_GAME = "game/joinGameForm";


    @Autowired
    private final GameService gameService;

    @Autowired
    private final PlayerService playerService;

    @ModelAttribute("games")
    public List <Game> findAllCreatedGames() {
        return this.gameService.findGameByStatus(GameStatus.INITIED);
    }


    @ModelAttribute("player")
    public Player findPlayer() {

        return this.playerService.getCurrentPlayer().get();
    }

    @Autowired
    public GameController(PlayerService playerService, GameService gameService) {
        this.playerService = playerService;
        this.gameService = gameService;

    }

    @GetMapping(value = "/create")
    public String initCreationForm(ModelMap model) {
        logger.info("initCreationForm");
        Game game = new Game();
        model.put("game", game);
        return VIEWS_GAME_CREATE_FORM;
    }

    @GetMapping(value = "/join")
    public String joinGame(ModelMap model) {
        return VIEWS_JOIN_GAME;
    }


    /**
     * method for creating a game.
     */
    @PostMapping(value = "/create")
    public String processCreationForm(@Valid @ModelAttribute(name = "game") Game game, BindingResult result, @Valid Player player) {

        String new_link;
        logger.info("createGame " + game.getName());

        if (result.hasErrors()) {
            return VIEWS_GAME_CREATE_FORM;
        }
        if (this.gameService.gameNameExists(game)) {
            logger.error("ERROR: already exists");
            result.rejectValue("name", "duplicate", "Already exists!");
            return VIEWS_GAME_CREATE_FORM;
        }

        if (player.checkAlreadyCreatedGames()) {
            logger.error("ERROR: already created");
            result.rejectValue("name", "already_created", "You already created a game!");
            return VIEWS_GAME_CREATE_FORM;
        }
        else {
            try {
                logger.info("creating Gamepieces");
                this.gameService.setPlayersOfGame(game, player);
                this.gameService.save(game);

                //this.gameService.initGame(game);

            } catch (Exception ex) {
                logger.error("ERROR: " + ex.getMessage());

                result.rejectValue("name", "exception", "An unexpected exception occured");
                return VIEWS_GAME_CREATE_FORM;
            }
            new_link = (game.getGameOption() == GameOption.PARCHIS) ? VIEWS_GAME_PARCHIS : VIEWS_GAME_OCA;
            new_link = new_link + game.getId();



        }
        logger.info("redirecting to" + new_link);
        return "redirect:/" + new_link;
    }


}
