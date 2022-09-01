package org.springframework.samples.parchis_oca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.Parchis;
import org.springframework.samples.parchis_oca.repository.GameBoardRepository;
import org.springframework.samples.parchis_oca.repository.ParchisRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParchisService {
	

    @Autowired
    private ParchisRepository parchisRepository;
    
    @SuppressWarnings("unused")
	@Autowired
    private GameBoardRepository gameBoardRepository;
    
    @Autowired
    BoardFieldService boardFieldService;

    @Autowired
    PlayerService playerService;
	
   
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
