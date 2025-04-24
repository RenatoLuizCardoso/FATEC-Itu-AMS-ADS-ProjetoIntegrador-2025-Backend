package br.fatec.easycoast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.easycoast.entities.Seat;

@Repository
public interface TableRepository extends JpaRepository<Seat, Integer> {
   
}
