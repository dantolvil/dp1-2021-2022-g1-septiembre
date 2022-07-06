package org.springframework.samples.parchis_oca.game;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.enums.GameStatus;
import org.springframework.samples.parchis_oca.player.Player;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameService {

	private GameRepository gameRepository;
	
	@Autowired
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	
	@Transactional
	public void save(Game game) throws DataAccessException {
		gameRepository.save(game);
	}

	
    public Optional <Game> findById(int i) {
        return gameRepository.findById(i);
    }


	public List<Game> findGameByStatus(GameStatus initied) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean gameNameExists(@Valid Game game) {
		// TODO Auto-generated method stub
		return false;
	}


	public void setPlayersOfGame(@Valid Game game, @Valid Player player) {
		// TODO Auto-generated method stub
		
	}



}
