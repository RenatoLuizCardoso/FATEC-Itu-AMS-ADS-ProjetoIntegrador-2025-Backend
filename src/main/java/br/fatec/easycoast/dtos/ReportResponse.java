package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public class ReportResponse {
    private Integer id;
    private String reportType;
    private LocalDateTime reportGenDate;
    private String reportData;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public LocalDateTime getReportGenDate() {
        return reportGenDate;
    }

    public void setReportGenDate(LocalDateTime reportGenDate) {
        this.reportGenDate = reportGenDate;
    }

    public String getReportData() {
        return reportData;
    }

    public void setReportData(String reportData) {
        this.reportData = reportData;
    }
}
