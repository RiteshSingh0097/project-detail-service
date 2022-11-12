package com.shobhit.project.detail.service.service;

import com.shobhit.project.detail.service.exception.UserNotFoundException;
import com.shobhit.project.detail.service.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void saveUser(User user);
    User getUserByNameAndPassword(String name, String password) throws UserNotFoundException;
}
