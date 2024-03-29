package org.springframework.samples.parchis_oca.web;

import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.service.GameService;
import org.springframework.samples.parchis_oca.service.OcaService;
import org.springframework.samples.parchis_oca.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/game/oca")
public class OcaController {

    @Autowired
    OcaService ocaService;
    
    @Autowired
    GameService gameService;
    
    @Autowired
    PlayerService playerService;
    
    private static final String VIEWS_GAME = "game/oca";
    private static final String VIEWS_JOIN_OCA = "game/oca/join/";

    @Autowired
    public OcaController(GameService gameService, OcaService ocaService, PlayerService playerservice){
        this.ocaService = ocaService;
        this.gameService = gameService;
        this.playerService = playerservice;
    }
    

    @GetMapping(value = "{gameid}")
    public String initCanvasForm(@PathVariable("gameid") int gameid, ModelMap model, HttpServletResponse response) {
        return "redirect:/" + VIEWS_JOIN_OCA + gameid;
    }

    @GetMapping(value = "/join/{gameid}")
    public String joinOca(@PathVariable("gameid") int gameid, ModelMap model, HttpServletResponse response) throws InterruptedException {
        response.addHeader("Refresh", "5");
        Optional <Game> gameOptional = this.gameService.findById(gameid);
        Game game = gameOptional.orElseThrow(EntityNotFoundException::new);

        model.addAttribute("currentuser", playerService.getCurrentPlayer().get());
        model.put("game",game);

        return VIEWS_GAME;
    }

    @GetMapping(value = "/join/{gameid}/quit")
    public String quitOca(@PathVariable("gameid") int gameid) {
        return "redirect:/";
    }

    @GetMapping(value = "/join/{gameid}/dice")
    public String diceGame(@PathVariable("gameid") int gameid, ModelMap model, HttpServletResponse response) {


        return "redirect:/" + VIEWS_JOIN_OCA + gameid;
    }

}
