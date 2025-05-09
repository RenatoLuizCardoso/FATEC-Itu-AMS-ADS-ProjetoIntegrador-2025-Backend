package br.fatec.easycoast.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.fatec.easycoast.entities.Scheduling;

@Repository
public interface SchedulingRepository extends JpaRepository<Scheduling, Integer> {
    
}