package tn.pi.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.pi.daos.UserDao;
import tn.pi.models.User;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j

public class UserController {

    private final UserDao repository;
    public UserController(UserDao repository) {
        this.repository = repository;
    }

    // GET all users
    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users =  repository.findAll();
        if (users.isEmpty()) {
            log.info("Users not found");
        }
        log.info("Users not found");

        return users;
    }

    @GetMapping("/users/{user_id}")
    public User findOneUser(@PathVariable String user_id) {
        return repository.findById(Integer.valueOf(user_id)).orElse(null);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        try {
            return repository.save(user);
        }
        catch (Exception e) {
            log.info("User not created"+ e.getMessage());
            return null;
        }
    }

}
