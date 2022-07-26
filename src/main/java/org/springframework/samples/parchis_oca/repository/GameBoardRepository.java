
package org.springframework.samples.parchis_oca.repository;

import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.Game;
import org.springframework.samples.parchis_oca.model.GameBoard;


public interface GameBoardRepository extends CrudRepository<Game, Integer> {

	Optional<GameBoard> findById(int id) throws DataAccessException;

	void save(GameBoard gameBoard);

}
