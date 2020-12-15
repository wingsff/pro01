package com.example.demojpa.service.impl;

import com.example.demojpa.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public void test1() {
        System.out.println("test1");
    }

    @Override
    public void test2() {
        System.out.println("test2");
    }

    public void test3() {
        System.out.println("test3");
    }
}
