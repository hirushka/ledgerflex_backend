package com.hiru96.ledgerflex.Security;


import com.hiru96.ledgerflex.Model.User;
import com.hiru96.ledgerflex.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.ExecutionException;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    //@Autowired
    //UserFirebaseService userFirebaseService;

    @Autowired
    UserRepo userRepo;

    @Override
//	@Transactional
    public UserDetails loadUserByUsername(String username) {
        User user = null;
        System.out.println(username);
        Optional<User> optionalUser = userRepo.findByUsername(username);
        if (optionalUser.isPresent()) {
             user = optionalUser.get();
        } else {
            System.out.println("Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());

    }


    public UserDetails loadUserById(Long id) throws ExecutionException, InterruptedException {

        User user = null;
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
             user = optionalUser.get();
        } else {
            System.out.println("Not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }
}
