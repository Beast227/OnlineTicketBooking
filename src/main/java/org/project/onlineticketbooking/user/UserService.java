package org.project.onlineticketbooking.user;

import jakarta.transaction.Transactional;
import org.project.onlineticketbooking.exception.InvalidCredentials;
import org.project.onlineticketbooking.exception.UserNotFound;
import org.project.onlineticketbooking.util.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final JwtUtil jwtUtil;
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public UserResponse findByEmail(String email) {
        return userRepository.findById(email)
                //.map(user -> new UserResponse(user.getUserName(), user.getEmail()))
                .map(UserResponse::from).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User findByEmailForAuth(String email) {
        return userRepository.findById(email).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Transactional
    public UserResponse createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return UserResponse.from(user);
    }

    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public UserResponse updateUser(User user) {
        User foundUser = userRepository.findById(user.getEmail()).orElseThrow(() -> new RuntimeException("User not found"));
        if (!user.getUserName().equals(foundUser.getUserName())) {
            foundUser.setUserName(user.getUserName());
        }
        if (!user.getPassword().equals(foundUser.getPassword())) {
            foundUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        userRepository.save(foundUser);
        return UserResponse.from(user);
    }

    public String loginUser(User user) {
        User foundUser = userRepository.findById(user.getEmail()).orElseThrow(() -> new UserNotFound("User not found"));

        if (!bCryptPasswordEncoder.matches(user.getPassword(), foundUser.getPassword())) {
            throw new InvalidCredentials("Pooped on");
        }

        UserDetailsImpl userDetails = new UserDetailsImpl(foundUser);

        return jwtUtil.getJwtToken(userDetails);

    }

}
