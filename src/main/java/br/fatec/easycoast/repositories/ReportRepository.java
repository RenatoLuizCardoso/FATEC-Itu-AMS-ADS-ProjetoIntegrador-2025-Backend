package br.fatec.easycoast.repositories;

import br.fatec.easycoast.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<Report, Integer> {
}
