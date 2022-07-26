
package org.springframework.samples.parchis_oca.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.Game;


public interface GameRepository extends CrudRepository<Game, Integer> {

	Optional<Game> findById(String Game);
	
	List<Game> findAll();

}
