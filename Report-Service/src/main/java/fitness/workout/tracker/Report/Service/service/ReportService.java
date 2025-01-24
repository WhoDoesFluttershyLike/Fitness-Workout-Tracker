package fitness.workout.tracker.Report.Service.service;

import fitness.workout.tracker.Report.Service.dto.ReportRequestDTO;
import fitness.workout.tracker.Report.Service.dto.ReportResponseDTO;
import fitness.workout.tracker.Report.Service.repository.ReportRepository;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public ReportResponseDTO generateReport(String token, ReportRequestDTO reportRequestDTO) {

    }

    private String getUserIdFromToken(String token) {
        // Вытаскиваем ID пользователя из токена
        // Реализуй метод, используя JWT
        return;
    }
}
