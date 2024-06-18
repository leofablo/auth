package com.montrackii.fixmontrack.user.service;

import com.montrackii.fixmontrack.user.dto.RegisterRequestDto;
import com.montrackii.fixmontrack.user.entity.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    Users register(RegisterRequestDto user);
    Users findByEmail(String email);
    Users findById(Long id);
    List<Users> findAll();
    void deleteById(Long id);
    Users profile();

}
