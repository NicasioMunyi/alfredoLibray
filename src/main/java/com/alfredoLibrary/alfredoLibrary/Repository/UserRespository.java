package com.alfredoLibrary.alfredoLibrary.Repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
    public  User findUserByName(String username);
}
