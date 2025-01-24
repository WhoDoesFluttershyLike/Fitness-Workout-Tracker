package fitness.workout.tracker.Workout.Service.repository;

import fitness.workout.tracker.Workout.Service.entity.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {

//    @Query("SELECT w FROM Workout w WHERE w.username = :username AND w.date BETWEEN :startDate AND :endDate")
//    List<Workout> findByUsernameAndDateBetween(@Param("username") String username, @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    List<Workout> findByUsername(String username);

    List<Workout> findByUsernameAndDateBetween(String username, LocalDate startDate, LocalDate endDate);
}
