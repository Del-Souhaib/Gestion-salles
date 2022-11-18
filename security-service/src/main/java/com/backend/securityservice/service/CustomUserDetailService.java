package com.backend.securityservice.service;

import com.backend.securityservice.model.MyUser;
import com.backend.securityservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService  implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser =userRepository.findFirstByEmail(username);
        if (myUser ==null)
            throw new UsernameNotFoundException(username);

        UserDetails userDetails= User.withUsername(myUser.getEmail()).password(myUser.getPassword()).authorities(myUser.getRole().getNom()).build();

        return userDetails;
    }

}
