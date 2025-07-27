package drug.inventory.management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import drug.inventory.management_system.Entity.User;
import drug.inventory.management_system.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) throws Exception {
        System.out.println("Registering user: " + user);
        if (userRepository.findByEmail(user.getEmail()) != null) {
            System.out.println("Email already exists: " + user.getEmail());
            throw new Exception("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        System.out.println("User saved: " + savedUser);
        return savedUser;
    }

    public User loginUser(String email, String password) throws Exception {
        System.out.println("Login attempt for email: " + email);
        User user = userRepository.findByEmail(email);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid email or password");
        }
        return user;
    }
}