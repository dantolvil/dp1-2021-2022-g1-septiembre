package org.springframework.samples.parchis_oca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.GameAction;
import org.springframework.samples.parchis_oca.repository.GameActionRepository;
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

	//Guardar una acción de juego @Transactional
	@Transactional
	public void save(GameAction gameAction) throws DataAccessException {
		gameActionRepository.save(gameAction);
	}
	

	//Encontrar una acción según el tipo de acción de juego
    @Transactional
    public Optional<GameAction> findGameActionByAction(String action) throws DataAccessException {
        return gameActionRepository.findByAction(action);
    }

    public Optional<GameAction> findById(int id) {
        return gameActionRepository.findById(id);
    }

}
