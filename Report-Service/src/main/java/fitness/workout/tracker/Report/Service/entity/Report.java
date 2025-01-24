package fitness.workout.tracker.Report.Service.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username; // ID пользователя
    private LocalDateTime startDate; // Период отчета: начало
    private LocalDateTime endDate;   // Период отчета: конец
    private double completionRate;  // Процент выполнения тренировок
    private String details;         // Дополнительная информация

    public void setUsername(String username) {
        this.username = username;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public double getCompletionRate() {
        return completionRate;
    }

    public String getDetails() {
        return details;
    }
}
