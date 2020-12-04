package com.example.demojpa.repository;

import com.example.demojpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
