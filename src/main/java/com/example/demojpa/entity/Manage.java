package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
@Entity
@Table(name = "t_manage")
public class Manage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long roleId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "age")
    private Integer age;

//    @Override
//    public String toString() {
//        applicants.forEach(applicant -> {
//            applicant.setApplicant(null);
//        });
//        return "Manage{" +
//                "roleId=" + roleId +
//                ", userName='" + userName + '\'' +
//                ", age=" + age +
//                ", applicants=" + applicants +
//                '}';

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
//    }

//    @OneToMany(targetEntity = Applicant.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = "manage")
    @OneToMany(mappedBy = "manage", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Applicant> applicants;
}
