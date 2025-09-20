package tn.pi.resources;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.pi.daos.PostDao;
import tn.pi.models.Post;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    private final PostDao repository;

    public PostController(PostDao repository) {
        this.repository = repository;
    }
    @GetMapping("/")
    public List<Post> findAll() {
        return repository.findAll();
    }
}
