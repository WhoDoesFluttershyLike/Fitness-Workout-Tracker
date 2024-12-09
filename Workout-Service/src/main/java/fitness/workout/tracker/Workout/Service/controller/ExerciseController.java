package fitness.workout.tracker.Workout.Service.controller;

import fitness.workout.tracker.Workout.Service.entity.Exercise;
import fitness.workout.tracker.Workout.Service.service.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @PostMapping
    public Exercise createExercise(@RequestBody Exercise exercise) {
        return exerciseService.createExercise(exercise);
    }

    @GetMapping
    public List<Exercise> getAllExercises() {
        return exerciseService.getAllExercises();
    }

    @GetMapping("/workout/{workoutId}")
    public List<Exercise> getExercisesByWorkoutId(@PathVariable Long workoutId) {
        return exerciseService.getExercisesByWorkoutId(workoutId);
    }

    @DeleteMapping("/{id}")
    public void deleteExercise(@PathVariable Long id) {
        exerciseService.deleteExercise(id);
    }


}
