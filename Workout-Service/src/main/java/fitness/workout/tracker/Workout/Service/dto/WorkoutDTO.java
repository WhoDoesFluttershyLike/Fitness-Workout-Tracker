package fitness.workout.tracker.Workout.Service.dto;



public class WorkoutDTO {
    private String name;


    private String comments;

    private boolean completed;

    public WorkoutDTO(String name, String comments, boolean completed) {
        this.name = name;
        this.comments = comments;
        this.completed = completed;
    }


    public String getName() {
        return name;
    }


    public String getComments() {
        return comments;
    }
    public boolean isCompleted() {
        return completed;
    }

}
