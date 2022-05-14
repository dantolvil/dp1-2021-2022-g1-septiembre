package org.springframework.samples.parchis_oca.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class ActionGameController {

	private final GameService gameService;

	@Autowired
	public ActionGameController(GameService gameService) {
		this.gameService = gameService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/*
	/**
	 * Called before each and every @GetMapping or @PostMapping annotated method. 2 goals:
	 * - Make sure we always have fresh data - Since we do not use the session scope, make
	 * sure that Pet object always has an id (Even though id is not part of the form
	 * fields)
	 * @param petId
	 * @return Pet
	 */
	/*@ModelAttribute("visit")
	public ActionGame loadPetWithVisit(@PathVariable("petId") int petId) {
		Game pet = this.petService.findPetById(petId);
		ActionGame visit = new ActionGame();
		//pet.addVisit(visit);
		return visit;
	}*/

	// Spring MVC calls method loadPetWithVisit(...) before initNewVisitForm is called
	//@GetMapping(value = "/owners/*/pets/{petId}/visits/new")
	//public String initNewVisitForm(@PathVariable("petId") int petId, Map<String, Object> model) {
		//return "pets/createOrUpdateVisitForm";
	//}
	/*
	// Spring MVC calls method loadPetWithVisit(...) before processNewVisitForm is called
	@PostMapping(value = "/owners/{ownerId}/pets/{petId}/visits/new")
	public String processNewVisitForm(@Valid ActionGame visit, BindingResult result) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}
		else {
			this.petService.saveVisit(visit);
			return "redirect:/owners/{ownerId}";
		}
	}*/
   
	//@GetMapping(value = "/owners/*/pets/{petId}/visits") 
	//public String showVisits(@PathVariable int petId, Map<String, Object> model) {
    //model.put("visits", this.petService.findPetById(petId).getVisits()); 
	//	return "visitList";
	//}
	
}
