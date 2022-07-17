
package org.springframework.samples.parchis_oca.game;

import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;


public interface GameBoardRepository extends CrudRepository<Game, Integer> {

	Optional<GameBoard> findById(int id) throws DataAccessException;

	void save(GameBoard gameBoard);

}
