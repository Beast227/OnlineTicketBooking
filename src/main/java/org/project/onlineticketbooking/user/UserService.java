package org.project.onlineticketbooking.user;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse findByEmail(String email) {
        return userRepository.findById(email)
                //.map(user -> new UserResponse(user.getUserName(), user.getEmail()))
                .map(UserResponse::from).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponse createUser(User user) {
        userRepository.save(user);
        return UserResponse.from(user);
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public UserResponse updateUser(User user) {
        userRepository.save(user);
        return UserResponse.from(user);
    }

    public String loginUser(User user) {
        try{
            User foundUser = userRepository.findById(user.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));

            if (foundUser.getPassword().equals(user.getPassword())) {
                return "your gayat";
            } else {
                return "invalid gayat";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "invalid gayat";
        }
    }

}
