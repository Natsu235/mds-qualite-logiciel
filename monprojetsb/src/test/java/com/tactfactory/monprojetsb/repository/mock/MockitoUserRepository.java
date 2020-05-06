package com.tactfactory.monprojetsb.repository.mock;

import com.tactfactory.monprojetsb.entity.User;
import com.tactfactory.monprojetsb.repository.UserRepository;

public class MockitoUserRepository {

	public final UserRepository userRepository;
    public User user;
    public User resultEntity;
    public Long number;

    public MockitoUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.number = 1L;
        this.user = new User();
        this.user.setFirstname("Firstname");
        this.user.setLastname("Lastname");
    }

    public void init() {
    	// TODO
    }

}
