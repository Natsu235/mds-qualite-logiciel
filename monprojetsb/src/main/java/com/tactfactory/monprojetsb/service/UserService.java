package com.tactfactory.monprojetsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojetsb.entity.User;
import com.tactfactory.monprojetsb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User item) {
        return this.userRepository.save(item);
    }

    public void delete(User item) {
        this.userRepository.delete(item);
    }

    public void update(User item) {
        this.userRepository.save(item);
    }

    public List<User> findAll() {
        return this.userRepository.findAll();
    }

}
