package com.example.demojpa.service;

import com.example.demojpa.entity.RoleDto;
import com.example.demojpa.entity.SysMember;
import com.example.demojpa.repository.SysMemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
@AllArgsConstructor
public class SysMemberService {

    private SysMemberRepository sysMemberRepository;

    public Page<Long> find(){
        Pageable pageable = PageRequest.of(1, 5);
//        Specification<SysMember> specification = (Specification<SysMember>) (root, criteriaQuery, criteriaBuilder) -> {
//            Predicate predicate = criteriaBuilder.conjunction();
//            Path<Object> roleId = root.get("roleId");
//            criteriaBuilder.equal(roleId, 3);
//            criteriaQuery.groupBy(root.get("memberId"));
//            return predicate;
//        };
//        return sysMemberRepository.findAll(specification, pageable);
//        return sysMemberRepository.findDistinctMemberIdByRoleId(3L, pageable);
        return sysMemberRepository.findDistinctMemberIdByRoleId(3L, pageable);
    }


    public List<Map> selelctAll(){
        Pageable pageable = PageRequest.of(1, 5);
        return sysMemberRepository.selelctAll(pageable);
    };
}
