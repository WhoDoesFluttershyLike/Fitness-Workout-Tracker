package fitness.workout.tracker.Auth.Service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "test", groupId = "auth-service-group"
    )
    void listener(String message){
        System.out.println("There is a message: "+message);
    }

}
