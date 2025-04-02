package br.fatec.easycoast.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TBL_REPORT")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reportType;
    private LocalDateTime reportGenDate;

    @Lob
    private String reportData;

    // Getters e Setters
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
