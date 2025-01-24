package fitness.workout.tracker.Report.Service.controller;

import fitness.workout.tracker.Report.Service.dto.ReportRequestDTO;
import fitness.workout.tracker.Report.Service.dto.ReportResponseDTO;
import fitness.workout.tracker.Report.Service.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final ReportService reportService;

    public RestController(ReportService reportService) {
        this.reportService = reportService;
    }
    @PostMapping("/generate")
    public ResponseEntity<ReportResponseDTO> generateReport(
            @RequestHeader("Authorization") String token,
            @RequestBody ReportRequestDTO reportRequestDTO) {

        ReportResponseDTO report = reportService.generateReport(token, reportRequestDTO);
        return ResponseEntity.ok(report);
    }
}
