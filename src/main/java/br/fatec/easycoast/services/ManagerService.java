package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.ManagerRequest;
import br.fatec.easycoast.dtos.ManagerResponse;
import br.fatec.easycoast.entities.Manager;
import br.fatec.easycoast.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;
    
    public ManagerResponse createManager(ManagerRequest request) {
        
        Manager manager = new Manager();
        manager.setName(request.name()); 
        manager.setLogin(request.login()); 
        manager.setPassword(request.password());
        
        managerRepository.save(manager);

        return new ManagerResponse(manager.getId(), manager.getName(), manager.getLogin());
    }
}

