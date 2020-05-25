package com.bovino.cdcdemo.service;

import com.bovino.cdcdemo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();
    User getUserById(Integer id);
    User saveNewUser(User user);
    ResponseEntity<Void> deleteUser(Integer[] id);
}
