package fitness.workout.tracker.Workout.Service.service;

import fitness.workout.tracker.Workout.Service.entity.Exercise;
import fitness.workout.tracker.Workout.Service.repository.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExercisesByWorkoutId(Long workoutId) {
        return exerciseRepository.findByWorkoutId(workoutId);
    }

    public Optional<Exercise> getExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

}
