package com.ctrenka.spring_mongodb_mysql_auth.service;

import com.ctrenka.spring_mongodb_mysql_auth.model.Person;
import com.ctrenka.spring_mongodb_mysql_auth.repository.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person user = personRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new UserDetailsImpl(user.getId(), user.getUserName(), user.getFirstName(), user.getLastName(), user.getPassword());
    }
}
