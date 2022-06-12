package org.springframework.samples.parchis_oca.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameActionService {

	private GameRepository gameRepository;
	
	private GameActionRepository gameActionRepository;
	

	@Autowired
	public GameActionService(GameActionRepository visitRepository) {
		this.gameActionRepository = gameActionRepository;
	}

	
	@Transactional
	public void saveActionGame(GameAction gameAction) throws DataAccessException {
		gameActionRepository.save(gameAction);
	}

}
