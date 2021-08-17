//package com.softserve.travelagency.security;
//
//import com.softserve.travelagency.dao.UserDao;
//import com.softserve.travelagency.model.User;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//
//@Service("UserDetailsServiceImplementation")
//@AllArgsConstructor
//@Transactional
//public class UserDetailsServiceImplementation implements UserDetailsService {
//
//    private final UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Optional<User> user = userDao.getUserByEmail(email);
//        if (user.isEmpty())
//            throw new UsernameNotFoundException("User not found");
//        return SecurityUserDetails.fromUser(user.get());
//    }
//}