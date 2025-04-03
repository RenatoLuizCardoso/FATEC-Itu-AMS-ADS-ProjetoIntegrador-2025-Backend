package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Chargeback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargebackRepository extends JpaRepository<Chargeback, Integer> {
}
