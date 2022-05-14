/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.parchis_oca.game;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Michael Isvy
 */
@Service
public class GameService {

	private GameRepository petRepository;
	
	private ActionGameRepository visitRepository;
	

	@Autowired
	public GameService(GameRepository petRepository,
			ActionGameRepository visitRepository) {
		this.petRepository = petRepository;
		this.visitRepository = visitRepository;
	}

/*	@Transactional(readOnly = true)
	public Collection<PetType> findPetTypes() throws DataAccessException {
		return petRepository.findPetTypes();
	}*/
	
	@Transactional
	public void saveVisit(ActionGame visit) throws DataAccessException {
		visitRepository.save(visit);
	}

	@Transactional(readOnly = true)
	public Game findPetById(int id) throws DataAccessException {
		return petRepository.findById(id);
	}

	/*public Collection<ActionGame> findVisitsByPetId(int petId) {
		return visitRepository.findByPetId(petId);
	}*/

}
