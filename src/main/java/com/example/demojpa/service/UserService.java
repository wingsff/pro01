package com.example.demojpa.service;

import com.example.demojpa.entity.User;
import com.example.demojpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
@Service
@AllArgsConstructor
public class UserService {

    UserRepository userRepository;

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }


}
