package br.fatec.easycoast.dtos;

import java.time.LocalDateTime;

public record ReportResponse(Integer id, String reportType, LocalDateTime reportGenDate, String reportData) { }
