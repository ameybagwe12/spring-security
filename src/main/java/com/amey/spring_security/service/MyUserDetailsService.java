package com.amey.spring_security.service;

import com.amey.spring_security.dao.UserRepo;
import com.amey.spring_security.model.User;
import com.amey.spring_security.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        if(user == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("USER 404");
        }
        return new UserPrincipal(user);
    }
}
