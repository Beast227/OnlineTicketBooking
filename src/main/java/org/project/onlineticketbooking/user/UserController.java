package org.project.onlineticketbooking.user;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public UserResponse create(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/update")
    public UserResponse update(@Valid @RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping("/data/{email}")
    public UserResponse data(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody User user) {
        return userService.loginUser(user);
    }

}
