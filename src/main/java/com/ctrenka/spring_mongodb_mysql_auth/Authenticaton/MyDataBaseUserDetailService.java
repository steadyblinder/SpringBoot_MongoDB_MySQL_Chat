package com.ctrenka.spring_mongodb_mysql_auth.Authenticaton;

import com.ctrenka.spring_mongodb_mysql_auth.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MyDataBaseUserDetailService implements UserDetailsService {

    @Bean
    public UserDetailsService userDetailsService(){
        return new MyDataBaseUserDetailService();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return null;
    }

}
