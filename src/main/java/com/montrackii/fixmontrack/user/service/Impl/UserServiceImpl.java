package com.montrackii.fixmontrack.user.service.Impl;

import com.montrackii.fixmontrack.exception.ApplicationException;
import com.montrackii.fixmontrack.user.dto.RegisterRequestDto;
import com.montrackii.fixmontrack.user.entity.Users;
import com.montrackii.fixmontrack.user.repository.UserRepository;
import com.montrackii.fixmontrack.user.service.UserService;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }


    @Override
    public Users register(RegisterRequestDto user) {
        Users newUser = user.toEntity();
        String encriptedPassword = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(encriptedPassword);
        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ApplicationException("User not found"));
    }

    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Users profile() {
        return null;
    }
}
