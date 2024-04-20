package com.alfredoLibrary.alfredoLibrary.helpers;

import com.alfredoLibrary.alfredoLibrary.Entity.Roles;
import com.alfredoLibrary.alfredoLibrary.Entity.Users;
import org.apache.catalina.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CustomUserDetails  implements UserDetails  {

    private String username;
    private  String password;

    Collection<? extends GrantedAuthority> authorities;
    public CustomUserDetails(Users userByname) {
        this.username = userByname.getUserName();
        this.password =userByname.getPassword();
        List<GrantedAuthority> auths = new ArrayList<>();

        for (Iterator<Role> it = (Iterator<Role>) userByname.getRoles(); it.hasNext(); ) {
            Roles role = (Roles) it.next();
            auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));


        }
        this.authorities = auths;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
