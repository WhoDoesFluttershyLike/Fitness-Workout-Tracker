package fitness.workout.tracker.Workout.Service.controller;

import fitness.workout.tracker.Workout.Service.dto.WorkoutDTO;
import fitness.workout.tracker.Workout.Service.entity.Workout;
import fitness.workout.tracker.Workout.Service.jwt.JwtService;
import fitness.workout.tracker.Workout.Service.service.WorkoutService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;
    private final JwtService jwtService;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public WorkoutController(WorkoutService workoutService, JwtService jwtService, KafkaTemplate<String, String> kafkaTemplate) {
        this.workoutService = workoutService;
        this.jwtService = jwtService;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Workout> createWorkout(
            @RequestHeader("Authorization") String token,
            @RequestBody WorkoutDTO workoutDTO) {

        String jwtToken = token.replace("Bearer ", "");
            String username = jwtService.extractUserFromToken(jwtToken);
            Workout workout = workoutService.createWorkout(username, workoutDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(workout);
    }

    @GetMapping
    public List<Workout> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/{id}")
    public Workout getWorkoutById(@PathVariable Long id) {
        return workoutService.getWorkoutById(id).orElse(null);
    }

    @GetMapping("/{username}")
    public List<Workout> getWorkoutByUsername(@PathVariable String username) {
        return workoutService.getWorkoutsByUserId(username);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
    }

//    @GetMapping("/{username}")
//    public List<Workout> getByDateBetween(@PathVariable String username,
//                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//                                          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
//       return workoutService.getWorkoutByUserIdAndDateBetween(username, startDate, endDate);
//    }

    @PostMapping("/message")
    public String sendMessage(@RequestParam String message){
        kafkaTemplate.send("test", message);
        return "Success";
    }
}
