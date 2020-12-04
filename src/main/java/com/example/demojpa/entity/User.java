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
@Data
@Entity
@Table(name = "sys_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "age")
    private Integer age;


    /**
     * 要是放弃维护权就将@JoinTable删除，并且换成@ManyToMany(mappedBy = "roles")属性，取对方关联的属性，级联用cascade
     * 一对多关系一般是放弃一的一方的维护权，因为会多一条update语句
     *
     */
    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "sys_user_role",
    joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<>();


}
