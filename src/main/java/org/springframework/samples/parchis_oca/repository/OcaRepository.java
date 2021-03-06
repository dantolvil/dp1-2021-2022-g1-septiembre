package org.springframework.samples.parchis_oca.repository;

import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.samples.parchis_oca.model.Oca;
import org.springframework.stereotype.Repository;

@Repository
public interface OcaRepository extends CrudRepository<Oca, Integer> {

    Oca findById(int id) throws DataAccessException;

    List<Oca> findAll() throws DataAccessException;


}