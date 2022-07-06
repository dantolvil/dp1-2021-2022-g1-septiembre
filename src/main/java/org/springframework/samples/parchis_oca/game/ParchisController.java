package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game/parchis")
public class ParchisController {

    @Autowired
    ParchisService parchisService;
    
    @Autowired
    GameService gameService;
    
    @Autowired
    PlayerService playerService;
    
    private static final String VIEWS_GAME = "game/parchis";
    private static final String VIEWS_JOIN_PARCHIS = "game/parchis/join/";

    @Autowired
    public ParchisController(GameService gameService, ParchisService parchisService, PlayerService playerservice){
        this.parchisService = parchisService;
        this.gameService = gameService;
        this.playerService = playerservice;
    }

    @GetMapping(value = "{gameid}")
    public String initCanvasForm(@PathVariable("gameid") String gameid, ModelMap model, HttpServletResponse response) {
        Optional <Game> game = gameService.findById(gameid);

        //ocaService.initGameBoard(game);
        return "redirect:/" + VIEWS_JOIN_PARCHIS + gameid;
    }

    @GetMapping(value = "/join/{gameid}")
    public String joinOca(@PathVariable("gameid") String gameid, ModelMap model, HttpServletResponse response) throws InterruptedException {
        response.addHeader("Refresh", "5");
        Optional < Game > gameOptional = this.gameService.findById(gameid);
        Game game = gameOptional.orElseThrow(EntityNotFoundException::new);
        Player player  = playerService.getCurrentPlayer().get();

        model.addAttribute("currentuser", playerService.getCurrentPlayer().get());
        model.put("game",game);

        return VIEWS_GAME;
    }

    @GetMapping(value = "/join/{gameid}/quit")
    public String quitParchis(@PathVariable("gameid") int gameid) {
        //this.gameService.quitGame(gameid);
        return "redirect:/";
    }

    @GetMapping(value = "/join/{gameid}/dice")
    public String diceRole(@PathVariable("gameid") String gameid, ModelMap model, HttpServletResponse response) {

        //check if this is the current user
        Optional <Game> game = gameService.findById(gameid);
        //gameService.save(game);


        return "redirect:/" + VIEWS_JOIN_PARCHIS + gameid;
    }
}