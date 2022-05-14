package org.springframework.samples.parchis_oca.game;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.parchis_oca.model.BaseEntity;


public interface ActionGameRepository extends Repository<ActionGame, Integer> {


	void save(ActionGame visit) throws DataAccessException;

	List<ActionGame> findById(Integer Id);

}
