package com.montrackii.fixmontrack.auth.entity;

import com.montrackii.fixmontrack.user.entity.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;


public class UserAuth extends Users implements UserDetails {
    private final Users users;

    public UserAuth(Users users){
        this.users = users;
    }

    @Override
    public String getPassword(){
        return users.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(() -> "Role_User");
        return authorities;
    }

    @Override
    public String getUsername(){
        return users.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
