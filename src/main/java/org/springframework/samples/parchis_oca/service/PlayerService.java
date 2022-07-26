package org.springframework.samples.parchis_oca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.Player;
import org.springframework.samples.parchis_oca.repository.PlayerRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PlayerService {

	private PlayerRepository playerRepository;	
	
	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}	

	//Recuperar el jugador actual
    public Optional <Player> getCurrentPlayer() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        return findPlayer(currentPrincipalName);
    }
    
    public Optional <Player> findPlayer(String player) {
        return playerRepository.findById(player);
    }

    //Guardar y crear un jugador @Transactional
	@Transactional
	public void savePlayer(Player player) throws DataAccessException {
		//creating player
		playerRepository.save(player);		
		
	}		

}
