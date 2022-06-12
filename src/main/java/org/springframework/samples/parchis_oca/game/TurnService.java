package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TurnService {

    @Autowired
    TurnRepository turnsRepository;

    @Autowired
    public TurnService(TurnRepository turnsRepository) {
        this.turnsRepository = turnsRepository;
    }

    @Transactional
    public void saveTurn(Turn turns) throws DataAccessException {
    	turnsRepository.save(turns);
    }

    public Optional<Turn> findTurn(int id) {
        return turnsRepository.findById(id);
    }

}
