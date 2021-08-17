package com.softserve.travelagency.service;

import com.softserve.travelagency.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean saveUser(User user);

    User getUserById(Long id);

    User getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
//