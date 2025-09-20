package tn.pi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.daos.UserDao;
import tn.pi.models.User;

import java.util.List;

@RestController
@RequestMapping("/api")
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
            throw new RuntimeException("User not found");
        }
        return users;
    }
}
