package com.shobhit.project.detail.service.repository;

import com.shobhit.project.detail.service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String userName, String password);

    User findByUsername(String username);
}