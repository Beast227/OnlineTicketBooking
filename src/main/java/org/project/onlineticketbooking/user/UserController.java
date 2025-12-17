package org.project.onlineticketbooking.user;

import jakarta.validation.Valid;
import org.project.onlineticketbooking.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final JwtUtil jwtUtil;

    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/create")
    public UserResponse create(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public UserResponse update(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/data")
    public UserResponse data(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");

        String email = jwtUtil.extractEmail(token);

        return userService.findByEmail(email);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User user) {
        return userService.loginUser(user);
    }

}
