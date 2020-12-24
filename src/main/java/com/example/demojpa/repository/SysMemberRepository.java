package com.example.demojpa.repository;

import com.example.demojpa.entity.Role;
import com.example.demojpa.entity.RoleDto;
import com.example.demojpa.entity.SysMember;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * @description
 * @date 2020/12/17
 */
public interface SysMemberRepository extends JpaRepository<SysMember, Long>, JpaSpecificationExecutor<SysMember> {

    Page<Long> findDistinctMemberIdByRoleId(Long roleId, Pageable pageable);

    @Query(value = "select distinct(MEMBER_ID) from sys_member where role_id = ?1",
            countQuery = "select count(distinct(MEMBER_ID)) from sys_member where role_id = ?1",
            nativeQuery = true)
    Page<Long> findByRoleId(Long roleId, Pageable pageable);

    @Query(value="select t0.*, t1.role_name as roleName from sys_member t0 left join sys_role t1 on t0.role_id = t1.role_id ",
            countQuery = "select count(1) from sys_member t0 left join sys_role t1 on t0.role_id = t1.role_id ",
            nativeQuery = true)
    List<Map> selelctAll(Pageable pageable );
}
