package fitness.workout.tracker.Report.Service.repository;

import fitness.workout.tracker.Report.Service.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}
