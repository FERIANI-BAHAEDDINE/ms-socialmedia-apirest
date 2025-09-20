package tn.pi.daos;


import org.springframework.data.jpa.repository.JpaRepository;
import tn.pi.models.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
