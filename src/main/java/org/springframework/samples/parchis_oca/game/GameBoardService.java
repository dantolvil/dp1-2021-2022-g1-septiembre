package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public class GameBoardService {
	

    @Autowired
    private GameBoardRepository gameBoardRepository;
	
    @Autowired
    public GameBoardService(GameBoardRepository gameBoardRepository) {
        this.gameBoardRepository = gameBoardRepository;
    }
	
	public Optional<GameBoard> findById(Integer id) {
        return gameBoardRepository.findById(id);
    }


    @Transactional
    public void save(GameBoard gameBoardField) throws DataAccessException {
    	gameBoardRepository.save(gameBoardField);
    }

}
