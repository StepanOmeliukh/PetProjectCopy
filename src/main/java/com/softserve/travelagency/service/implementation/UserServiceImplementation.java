package com.softserve.travelagency.service.implementation;

import com.softserve.travelagency.dao.UserDao;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImplementation implements UserService {

    @Autowired
    private final UserDao userDao;

    @Override
    public boolean saveUser(User user) {
        Optional<User> userDatabase = userDao.getUserByEmail(user.getEmail());

        if (userDatabase.isPresent()) {
            return false;
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userDao.saveUser(user);
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