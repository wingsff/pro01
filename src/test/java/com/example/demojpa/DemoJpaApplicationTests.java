package com.example.demojpa;

import com.example.demojpa.entity.Role;
import com.example.demojpa.entity.SysMember;
import com.example.demojpa.entity.User;
import com.example.demojpa.repository.RoleRepository;
import com.example.demojpa.repository.UserRepository;
import com.example.demojpa.service.SysMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.List;

@SpringBootTest
class DemoJpaApplicationTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    SysMemberService sysMemberService;

    @Test
    void contextLoads() {
    }

    @Test
    void testGroupBy(){
        Page<Long> sysMembers = sysMemberService.find();
        System.out.println();

    };



    @Test
    @Transactional
    @Rollback(false)
    void addTest(){
        User user = new User();
        user.setAge(18);
        user.setUserName("张三");
        Role role = new Role();
        role.setRoleName("项目经理");
        user.getRoles().add(role);
        userRepository.save(user);
        roleRepository.save(role);

        Specification<User> spec2 = (Specification<User>) (root, criteriaQuery, criteriaBuilder) -> {
            Path<Object> userName = root.get("userName");
            Predicate predicate = criteriaBuilder.equal(userName, "xxx");
            return predicate;
        };
        };
    }
