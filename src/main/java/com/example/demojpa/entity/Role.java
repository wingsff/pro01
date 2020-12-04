package com.example.demojpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
@Entity
@Table(name = "sys_role")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "sys_user_role",
            joinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")})
    private Set<User> roles = new HashSet<>();

}
