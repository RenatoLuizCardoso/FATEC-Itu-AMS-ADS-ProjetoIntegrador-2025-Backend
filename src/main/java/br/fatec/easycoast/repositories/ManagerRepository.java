package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {
    Optional<Manager> findByLogin(String login);
}

