package fitness.workout.tracker.Auth.Service.controller;

import fitness.workout.tracker.Auth.Service.entity.User;
import fitness.workout.tracker.Auth.Service.response.AuthenticationResponse;
import fitness.workout.tracker.Auth.Service.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody User request
    ) {
        return ResponseEntity.ok(userService.authenticate(request));
    }

    @PostMapping("/refresh_token")
    public ResponseEntity refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        return userService.refreshToken(request, response);
    }

    @GetMapping("/{id}")
    public boolean getUser(@PathVariable Long id){
        return userService.findUserById(id);
    }


}
