package org.springframework.samples.parchis_oca.player;

import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayerController {

	private static final String VIEWS_PLAYER_CREATE_OR_UPDATE_FORM = "players/createOrUpdateOwnerForm";

	private static final String VIEWS_PLAYERS_CREATE_OR_UPDATE_FORM = null;

    @Autowired
    private PlayerService playerService;

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	//HTTP(GET). Mediante GET se recuperan los datos de la entidad Player.
	@GetMapping(value = "/player/new")
	public String initCreationForm(Map<String, Object> model) {
		Player player = new Player();
		model.put("player", player);
		return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
	}

	//HTTP(POST). Si no se producen errores en el modelo, se guardan los datos en el servicio usando el método save(). 
	// Por el contrario, si se produce un error se nos redirecciona a la vista con el formulario para la creación.
	@PostMapping(value = "/players/new")
	public String processCreationForm(@Valid Player player, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.playerService.savePlayer(player);
			
			return "redirect:/players/" + player.getId();
		}
	}

	@GetMapping(value = "/players/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("player", new Player());
		return "players/findPlayers";
	}

	//Mediante el uso del servicio PlayerService se obtiene el jugador que va a
	//ser modificado a través de su Id y se redirecciona a la vista de edición.
	@GetMapping(value = "/players/{playerId}/edit")
	public String initUpdatePlayerForm(@PathVariable("playerId") String playerId, Model model) {
		Optional<Player> player = this.playerService.findPlayer(playerId);
		model.addAttribute(player);
		return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
	}


	//Al realizar la edición del jugador se comprueba si presenta errores, 
	//si todo ha ido bien se redirecciona a la vista de los detalles del jugador.
	//Por el contrario, si se encuentran errores se devolverá a la vista anterior. 
	@PostMapping(value = "/players/{playerId}/edit")
	public String processUpdatePlayerForm(@Valid Player player, BindingResult result,
			@PathVariable("playerId") int playerId) {
		if (result.hasErrors()) {
			return VIEWS_PLAYERS_CREATE_OR_UPDATE_FORM;
		}
		else {
			player.setId(playerId);
			this.playerService.savePlayer(player);
			return "redirect:/players/{playerId}";
		}
	}

	//Se muestra el jugador que se obtiene por url a través del playerId.
	@GetMapping("/players/{playerId}")
	public ModelAndView showOwner(@PathVariable("playerId") String playerId) {
		ModelAndView mav = new ModelAndView("players/playerDetails");
		mav.addObject(this.playerService.findPlayer(playerId));
		return mav;
	}

}
