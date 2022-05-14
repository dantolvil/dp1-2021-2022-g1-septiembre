package org.springframework.samples.parchis_oca.game;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/owners/{ownerId}")
public class GameController {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

	private final GameService petService;
        private final PlayerService ownerService;

	@Autowired
	public GameController(GameService petService, PlayerService ownerService) {
		this.petService = petService;
                this.ownerService = ownerService;
	}

	/*@ModelAttribute("types")
	public Collection<PetType> populatePetTypes() {
		return this.petService.findPetTypes();
	}*/

	@ModelAttribute("owner")
	public Player findOwner(@PathVariable("ownerId") int ownerId) {
		return this.ownerService.findOwnerById(ownerId);
	}
        
        /*@ModelAttribute("pet")
	public Pet findPet(@PathVariable("petId") Integer petId) {
            Pet result=null;
		if(petId!=null)
                    result=this.clinicService.findPetById(petId);
                else
                    result=new Pet();
            return result;
	}*/
                
	@InitBinder("owner")
	public void initOwnerBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	/*@InitBinder("pet")
	public void initPetBinder(WebDataBinder dataBinder) {
		dataBinder.setValidator(new PetValidator());
	}*/

	@GetMapping(value = "/pets/new")
	public String initCreationForm(Player owner, ModelMap model) {
		Game pet = new Game();
		owner.addPet(pet);
		model.put("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

	/*@PostMapping(value = "/pets/new")
	public String processCreationForm(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		}
		else {
                    try{
                    	owner.addPet(pet);
                    	this.petService.savePet(pet);
                    }catch(DuplicatedPetNameException ex){
                        result.rejectValue("name", "duplicate", "already exists");
                        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
                    }
                    return "redirect:/owners/{ownerId}";
		}
	}*/

	@GetMapping(value = "/pets/{petId}/edit")
	public String initUpdateForm(@PathVariable("petId") int petId, ModelMap model) {
		Game pet = this.petService.findPetById(petId);
		model.put("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

    /**
     *
     * @param pet
     * @param result
     * @param petId
     * @param model
     * @param owner
     * @param model
     * @return
     */
        @PostMapping(value = "/pets/{petId}/edit")
	public String processUpdateForm(@Valid Game pet, BindingResult result, Player owner,@PathVariable("petId") int petId, ModelMap model) {
		if (result.hasErrors()) {
			model.put("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		}
		else {
                        Game petToUpdate=this.petService.findPetById(petId);
			BeanUtils.copyProperties(pet, petToUpdate, "id","owner","visits");                                                                                  
                   /* try {                    
                        this.petService.savePet(petToUpdate);                    
                    } catch (DuplicatedPetNameException ex) {
                        result.rejectValue("name", "duplicate", "already exists");
                        return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
                    }*/
			return "redirect:/owners/{ownerId}";
		}
	}

}
