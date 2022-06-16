package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameActionService {


	@Autowired
	private GameActionRepository gameActionRepository;
	

	@Autowired
	public GameActionService(GameActionRepository gameActionRepository) {
		this.gameActionRepository = gameActionRepository;
	}

	
	@Transactional
	public void save(GameAction gameAction) throws DataAccessException {
		gameActionRepository.save(gameAction);
	}
	


    @Transactional
    public Optional<GameAction> findGameActionByAction(String action) throws DataAccessException {
        return gameActionRepository.findByAction(action);
    }

    public Optional<GameAction> findById(int id) {
        return gameActionRepository.findById(id);
    }

}
