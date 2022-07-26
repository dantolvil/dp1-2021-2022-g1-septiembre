package org.springframework.samples.parchis_oca.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.parchis_oca.model.BoardField;
import org.springframework.samples.parchis_oca.model.GameBoard;

public interface BoardFieldRepository extends CrudRepository <BoardField, Integer > {
	
    public BoardField findByNumberAndBoard(@Param("number") Integer number, @Param("gameBoard") GameBoard gameBoard) throws DataAccessException;


}