package fitness.workout.tracker.Workout.Service.service;

import fitness.workout.tracker.Workout.Service.dto.WorkoutDTO;
import fitness.workout.tracker.Workout.Service.entity.Workout;
import fitness.workout.tracker.Workout.Service.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout createWorkout(String username, WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        workout.setName(workoutDTO.getName());
        workout.setUserName(username);
        workout.setCompleted(workoutDTO.isCompleted());
        workout.setComments(workoutDTO.getComments());
        return workoutRepository.save(workout);
    }

    public List<Workout> getAllWorkouts() {
        return workoutRepository.findAll();
    }

    public Optional<Workout> getWorkoutById(Long id) {
        return workoutRepository.findById(id);
    }

    public List<Workout> getWorkoutsByUserId(String username) {
        return workoutRepository.findByUsername(username);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }

//    public List<Workout> getWorkoutByUserIdAndDateBetween(String username, LocalDate startDate, LocalDate endDate) {
//        return workoutRepository.findByUsernameAndDateBetween(username, startDate, endDate);
//    }

}
