package tn.pi.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.models.Post;

public interface PostDao extends JpaRepository<Post,Integer> {
}
