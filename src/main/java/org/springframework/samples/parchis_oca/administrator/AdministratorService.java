package org.springframework.samples.parchis_oca.administrator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdministratorService {
    
    @Autowired
    private AdministratorRepository administratorRepository;

    @Transactional
    public int getNumberOfAdmins() {
        return (int) administratorRepository.count();
    }

   
    @Transactional(readOnly = true)
    public Optional<Administrator> getAdminByName(String n) {
        return administratorRepository.findAdminByName(n);
    }
    
    @Transactional
    public Optional<Administrator> findAdminById(int id){
        return administratorRepository.findById(id);
    }
    
    @Transactional
    public void save(Administrator admin){
    	administratorRepository.save(admin);
    }
}
