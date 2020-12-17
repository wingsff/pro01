package com.example.demojpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @date 2020/12/17
 */
@Entity
@Table(name = "sys_member")
@Data
public class SysMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "role_id")
    private Long roleId;


}
