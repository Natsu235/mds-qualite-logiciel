package com.tactfactory.monprojetsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
