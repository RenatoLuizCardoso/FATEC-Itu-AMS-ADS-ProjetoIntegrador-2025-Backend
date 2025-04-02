package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.ManagerRequest;
import br.fatec.easycoast.dtos.ManagerResponse;
import br.fatec.easycoast.entities.Manager;
import br.fatec.easycoast.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public ManagerResponse createManager(ManagerRequest request) {
        Manager manager = new Manager();
        manager.setName(request.getName());
        manager.setLogin(request.getLogin());
        manager.setPassword(request.getPassword()); // Senha já será criptografada

        managerRepository.save(manager);
        
        ManagerResponse response = new ManagerResponse();
        response.setId(manager.getId());
        response.setName(manager.getName());
        response.setLogin(manager.getLogin());

        return response;
    }
}
