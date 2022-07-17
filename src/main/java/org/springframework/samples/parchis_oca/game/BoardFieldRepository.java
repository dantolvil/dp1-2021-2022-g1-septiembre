package org.springframework.samples.parchis_oca.game;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BoardFieldRepository extends CrudRepository <BoardField, Integer > {
	
    public BoardField findByNumberAndBoard(@Param("number") Integer number, @Param("gameBoard") GameBoard gameBoard) throws DataAccessException;


}