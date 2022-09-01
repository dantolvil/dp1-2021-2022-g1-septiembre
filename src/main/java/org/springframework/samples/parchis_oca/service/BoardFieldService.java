package org.springframework.samples.parchis_oca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.parchis_oca.model.BoardField;
import org.springframework.samples.parchis_oca.model.GameBoard;
import org.springframework.samples.parchis_oca.repository.BoardFieldRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
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

    public BoardField find(Integer number, GameBoard gameBoard) {
        return this.boardFieldRepository.findByNumberAndGameBoard(number, gameBoard);
    }

    public BoardField getNextBoardFieldByNumberBoard(Integer i, GameBoard gameBoard) {
        return this.boardFieldRepository.findByNumberAndGameBoard(i, gameBoard).nextBoardField;
    }

}
