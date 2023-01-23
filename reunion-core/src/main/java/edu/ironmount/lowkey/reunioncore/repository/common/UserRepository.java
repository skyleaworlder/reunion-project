package edu.ironmount.lowkey.reunioncore.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ironmount.lowkey.reunioncore.model.common.User;

public interface UserRepository extends JpaRepository<User, Long> {}
