package com.example.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Administrator
 * @description
 * @date 2020/12/1
 */
@Entity
@Table(name = "t_applicant")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "applicant")
    private String applicant;

    @ManyToOne(targetEntity = Manage.class)
    @JoinColumn(name = "userId", referencedColumnName = "id")
//    @JsonIgnoreProperties(value = "applicants")
    private Manage manage;

//    @Override
//    public String toString() {
//        if(manage != null){
//            manage.getApplicants().clear();
//        }
//        return "Applicant{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", applicant='" + applicant + '\'' +
//                ", manage=" + manage +
//                '}';
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public Manage getManage() {
        return manage;
    }

    public void setManage(Manage manage) {
        this.manage = manage;
    }
}
