package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.transaction.annotation.Transactional;

public class ParchisService {
	

    @Autowired
    private ParchisRepository parchisRepository;
    
    @Autowired
    private GameBoardRepository gameBoardRepository;
    
    @Autowired
    BoardFieldService boardFieldService;

    @Autowired
    PlayerService playerService;
	
    @Autowired
    public ParchisService(ParchisRepository parchisRepository) {
        this.parchisRepository = parchisRepository;
    }
    
    @Autowired
    public ParchisService(ParchisRepository parchisRepository,
                           GameBoardRepository gameBoardRepository, BoardFieldService boardFieldService,
                          PlayerService playerService) {
        this.parchisRepository = parchisRepository;
        this.gameBoardRepository = gameBoardRepository;
        this.boardFieldService = boardFieldService;
        this.playerService = playerService;

    }
	
	public Optional<Parchis> findById(Integer id) {
        return parchisRepository.findById(id);
    }


    @Transactional
    public void save(Parchis parchis) throws DataAccessException {
    	parchisRepository.save(parchis);
    }

}
