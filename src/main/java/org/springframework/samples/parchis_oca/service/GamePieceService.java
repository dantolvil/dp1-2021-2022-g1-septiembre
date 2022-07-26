package org.springframework.samples.parchis_oca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.GamePiece;
import org.springframework.samples.parchis_oca.repository.GamePieceRepository;
import org.springframework.transaction.annotation.Transactional;

public class GamePieceService {
	

    @Autowired
    private GamePieceRepository gamePieceRepository;
	
    @Autowired
    public GamePieceService(GamePieceRepository gamePieceRepository) {
        this.gamePieceRepository = gamePieceRepository;
    }
	
	public Optional<GamePiece> findById(Integer id) {
        return gamePieceRepository.findById(id);
    }

    @Transactional
    public void save(GamePiece gamePiece) throws DataAccessException {
    	gamePieceRepository.save(gamePiece);
    }

}
