package com.alfredoLibrary.alfredoLibrary;

import com.alfredoLibrary.alfredoLibrary.Repository.UserRespository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRespository userRespository;

    private  static final Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
