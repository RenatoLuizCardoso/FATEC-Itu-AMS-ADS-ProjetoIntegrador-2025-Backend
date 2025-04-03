package br.fatec.easycoast.services;

import br.fatec.easycoast.dtos.ReportRequest;
import br.fatec.easycoast.dtos.ReportResponse;
import br.fatec.easycoast.entities.Report;
import br.fatec.easycoast.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public ReportResponse generateReport(ReportRequest request) {
        // Criando um novo relatório
        Report report = new Report();
        report.setReportType(request.reportType());
        report.setReportGenDate(LocalDateTime.now());
        report.setReportData(request.reportData());

        // Salvando o relatório no banco de dados
        reportRepository.save(report);

        // Retornando a resposta com as informações do relatório gerado
        return new ReportResponse(
                report.getId(),
                report.getReportType(),
                report.getReportGenDate(),
                report.getReportData()
        );
    }
}
