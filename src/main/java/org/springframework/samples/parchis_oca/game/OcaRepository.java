package org.springframework.samples.parchis_oca.game;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcaRepository extends JpaRepository<Oca, Integer> {

    Oca findById(int id) throws DataAccessException;

    List<Oca> findAll() throws DataAccessException;


}