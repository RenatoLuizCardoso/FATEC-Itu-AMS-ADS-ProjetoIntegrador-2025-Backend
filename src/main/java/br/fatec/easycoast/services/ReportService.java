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
        Report report = new Report();
        report.setReportType(request.getReportType());
        report.setReportGenDate(LocalDateTime.now());
        report.setReportData(request.getReportData());

        reportRepository.save(report);

        ReportResponse response = new ReportResponse();
        response.setId(report.getId());
        response.setReportType(report.getReportType());
        response.setReportGenDate(report.getReportGenDate());
        response.setReportData(report.getReportData());

        return response;
    }
}
