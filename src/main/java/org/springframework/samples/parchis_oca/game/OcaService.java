package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.player.PlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OcaService {
	

    @Autowired
    private GameBoardRepository gameBoardRepository;
    
    @Autowired
    private OcaRepository ocaRepository;


    @Autowired
    private BoardFieldService boardFieldService;


    @Autowired
    private PlayerService playerService;
	
   
    @Autowired
    public OcaService(OcaRepository ocaRepository, GameBoardRepository gameBoardRepository,
                      BoardFieldService boardFieldService, PlayerService playerService) {
    	
        this.ocaRepository = ocaRepository;
        this.gameBoardRepository = gameBoardRepository;
        this.boardFieldService = boardFieldService;
        this.playerService = playerService;

    }
    
    public Optional < Oca > findById(Integer id) {
        return ocaRepository.findById(id);
    }
	

    @Transactional
    public void save(GameBoard gameBoardField) throws DataAccessException {
    	gameBoardRepository.save(gameBoardField);
    }
    
    @Transactional
    public void save(Oca oca) throws DataAccessException {
        ocaRepository.save(oca);
    }
    

}
