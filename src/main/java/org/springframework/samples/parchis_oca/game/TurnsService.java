package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TurnsService {

    @Autowired
    TurnsRepository turnsRepository;

    @Autowired
    public TurnsService(TurnsRepository turnsRepository) {
        this.turnsRepository = turnsRepository;
    }

    @Transactional
    public void saveTurn(Turns turns) throws DataAccessException {
    	turnsRepository.save(turns);
    }

    public Optional<Turns> findTurn(int id) {
        return turnsRepository.findById(id);
    }

}
