package com.alfredoLibrary.alfredoLibrary.Repository;


import com.alfredoLibrary.alfredoLibrary.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    public  Users findUserByUserName(String username);
}
