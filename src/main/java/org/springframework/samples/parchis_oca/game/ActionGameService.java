package org.springframework.samples.parchis_oca.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActionGameService {

	private GameRepository gameRepository;
	
	private ActionGameRepository actionGameRepository;
	

	@Autowired
	public ActionGameService(ActionGameRepository visitRepository) {
		this.actionGameRepository = actionGameRepository;
	}

	
	@Transactional
	public void saveActionGame(ActionGame actionGame) throws DataAccessException {
		actionGameRepository.save(actionGame);
	}

}
