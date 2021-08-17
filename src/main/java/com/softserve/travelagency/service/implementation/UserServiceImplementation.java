package com.softserve.travelagency.service.implementation;

import com.softserve.travelagency.dao.UserDao;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.enums.UserEnums;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
@Transactional
@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    @Qualifier("UserDao")
    @Autowired
    private final UserDao userDao;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

     @Override
    public boolean saveUser(User user) {
        Optional<User> userDB = userDao.getUserByEmail(user.getEmail());

        if (userDB.isPresent()) {
            return false;
        }

        user.setRoles(UserEnums.USER);
        user.setEncryptedPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userDao.addUser(user);
        return true;
    }
    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.getUserByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

}
//