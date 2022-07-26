package org.springframework.samples.parchis_oca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.model.GameBoard;
import org.springframework.samples.parchis_oca.repository.GameBoardRepository;
import org.springframework.transaction.annotation.Transactional;

public class GameBoardService {
	

    @Autowired
    private GameBoardRepository gameBoardRepository;
	
    @Autowired
    public GameBoardService(GameBoardRepository gameBoardRepository) {
        this.gameBoardRepository = gameBoardRepository;
    }
	
	public Optional<Game> findById(Integer id) {
        return gameBoardRepository.findById(id);
    }


    @Transactional
    public void save(GameBoard gameBoard) throws DataAccessException {
    	gameBoardRepository.save(gameBoard);
    }

}
