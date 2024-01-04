package com.hiru96.ledgerflex.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hiru96.ledgerflex.Model.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
