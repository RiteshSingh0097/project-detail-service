package com.shobhit.project.detail.service.service.impl;

import com.shobhit.project.detail.service.exception.UserNotFoundException;
import com.shobhit.project.detail.service.model.User;
import com.shobhit.project.detail.service.model.UserDetailsImpl;
import com.shobhit.project.detail.service.repository.UserRepository;
import com.shobhit.project.detail.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
    @Override
    public User getUserByNameAndPassword(String name, String password) throws UserNotFoundException {
        return userRepository.findByUsernameAndPassword(name, password).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userRepository.findByUsername(username);

        return new UserDetailsImpl(user);
    }
}
