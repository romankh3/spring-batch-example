package com.github.romankh3.springbatchexample.repository;

import com.github.romankh3.springbatchexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
