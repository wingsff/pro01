package com.example.demojpa.controller;

import com.example.demojpa.entity.Role;
import com.example.demojpa.entity.User;
import com.example.demojpa.repository.RoleRepository;
import com.example.demojpa.repository.UserRepository;
import com.example.demojpa.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
@RestController
@AllArgsConstructor
public class TestController {

    UserService userService;

    @RequestMapping("/test")
    public User test(){
        User user = new User();
        user.setAge(18);
        user.setUserName("张三");
        Role role = new Role();
        role.setRoleName("项目经理");
        user.getRoles().add(role);
        return userService.save(user);
    }
}
