package com.tactfactory.monprojetsb.repository.mock;

import java.util.Arrays;
import java.util.Optional;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.tactfactory.monprojetsb.entity.User;
import com.tactfactory.monprojetsb.repository.UserRepository;

public class MockitoUserRepository {

    protected final UserRepository repository;
    public User entity;
    public User resultEntity;
    public Long number;
    public Optional<User> resultOptional;

    public MockitoUserRepository(UserRepository repository) {
        this.repository = repository;
        this.number = 1L;
        this.entity = new User();
        this.entity.setFirstname("Firstname_1");
        this.entity.setLastname("Lastname_1");
    }

    public void init() {
        // this.configure();

        this.resultEntity = new User();
        this.resultEntity.setId(this.entity.getId());
        this.resultEntity.setFirstname(this.entity.getFirstname());
        this.resultEntity.setLastname(this.entity.getLastname());

        Mockito.when(this.repository.findById(1L)).thenReturn(this.resultOptional);

        Mockito.when(this.repository.findAll((Pageable) ArgumentMatchers.any()))
                .thenReturn(new PageImpl<>(Arrays.asList(this.resultEntity)));

        Mockito.when(this.repository.save(ArgumentMatchers.any())).thenAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocation) throws Throwable {
                User user = invocation.getArgument(0);
                user.setId(1L);
                MockitoUserRepository.this.number++;
                return MockitoUserRepository.this.resultEntity;
            }
        });

        Mockito.when(this.repository.count()).thenAnswer(new Answer<Long>() {
            @Override
            public Long answer(InvocationOnMock invocation) throws Throwable {
                return MockitoUserRepository.this.number;
            }
        });

    }

}
