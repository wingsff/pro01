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
@Data
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
//    }

//    @OneToMany(targetEntity = Applicant.class, fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = "manage")
    @OneToMany(mappedBy = "manage", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Applicant> applicants = new HashSet<>();
}
