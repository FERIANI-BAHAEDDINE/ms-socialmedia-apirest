package tn.pi.resources;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.pi.daos.PostDao;
import tn.pi.daos.UserDao;
import tn.pi.models.Post;
import tn.pi.models.User;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j

public class UserController {

    private final UserDao userDao;
    public UserController(UserDao userDao, PostDao postDao) {
        this.userDao = userDao;
        this.postDao = postDao;
    }
    private final PostDao postDao;
    public PostDao getPostDao(PostDao postDao) {
        return postDao;
    }

    // GET all users
    @GetMapping("/users")
    public List<User> findAll() {
        List<User> users =  userDao.findAll();
        if (users.isEmpty()) {
            log.info("Users not found");
        }
        log.info("Users not found");

        return users;
    }

    @GetMapping("/users/{user_id}")
    public User findOneUser(@PathVariable String user_id) {
        return userDao.findById(Integer.valueOf(user_id)).orElse(null);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        try {
            return userDao.save(user);
        }
        catch (Exception e) {
            log.info("User not created"+ e.getMessage());
            return null;
        }
    }
    @DeleteMapping("/users/{id_user}")
    public String DeleteUser(@PathVariable Integer id_user) {
        try {
            userDao.deleteById(id_user);
            return "ok";
        }
        catch (Exception e) {
            log.info("User not deleted"+ e.getMessage());
            return null;
        }
    }
    @PostMapping("/users/{id}/post")
    public Post createUserPost(@RequestBody Post post, @PathVariable Integer id) {
        try {
            User user = userDao.findById(id).orElse(null);
            post.setUser(user);
            return postDao.save(post);

        }
        catch (Exception e) {
            log.info("post not created"+ e.getMessage());
            return null;
        }

    }

}
