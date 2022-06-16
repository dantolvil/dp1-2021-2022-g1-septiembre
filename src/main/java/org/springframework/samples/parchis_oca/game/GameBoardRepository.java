
package org.springframework.samples.parchis_oca.game;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;


public interface GameBoardRepository extends Repository<Game, Integer> {

	Optional<GameBoard> findById(int id) throws DataAccessException;

	void save(GameBoard gameBoard) throws DataAccessException;

}
