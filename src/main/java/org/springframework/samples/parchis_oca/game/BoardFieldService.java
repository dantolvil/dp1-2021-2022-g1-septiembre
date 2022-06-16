package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

public class BoardFieldService {

    @Autowired
    BoardFieldRepository boardFieldRepository;
    
    
    @Autowired
    public BoardFieldService(BoardFieldRepository boardFieldRepository) {
        this.boardFieldRepository = boardFieldRepository;
    }
    
    public Optional<BoardField> findById(Integer id) {
        return boardFieldRepository.findById(id);
    }
    
    @Transactional
    public void save(BoardField field) throws DataAccessException {
    	boardFieldRepository.save(field);
    }

    public BoardField find(Integer number, GameBoard board) {
        return this.boardFieldRepository.findByNumberBoard(number, board);
    }

    public BoardField getNextBoardFieldByNumberBoard(Integer i, GameBoard gameBoard) {
        return this.boardFieldRepository.findByNumberBoard(i, gameBoard).nextBoardField;
    }
}
