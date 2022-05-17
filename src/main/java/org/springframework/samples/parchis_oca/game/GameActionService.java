package org.springframework.samples.parchis_oca.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameActionService {

	private GameRepository gameRepository;
	
	private GameActionRepository actionGameRepository;
	

	@Autowired
	public GameActionService(GameActionRepository visitRepository) {
		this.actionGameRepository = actionGameRepository;
	}

	
	@Transactional
	public void saveActionGame(GameAction actionGame) throws DataAccessException {
		actionGameRepository.save(actionGame);
	}

}
