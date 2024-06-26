package com.alfredoLibrary.alfredoLibrary.Service;

import com.alfredoLibrary.alfredoLibrary.Entity.Users;
import com.alfredoLibrary.alfredoLibrary.Repository.UserRepository;
import com.alfredoLibrary.alfredoLibrary.helpers.CustomUserDetails;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRespository;

    private  static final Logger logger = (Logger) LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Entering in loadUserByUsername Method ..");
        Users user = userRespository.findUserByUserName(username);
        if(user == null){
            logger.error("User not found " + username);
            throw new UsernameNotFoundException("User could not be found ..!");

        }

        logger.info("User Authenticated Successfully ..!!");
        return  new CustomUserDetails(user);

    }
}
