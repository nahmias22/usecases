package com.demo.usecases.repo;

import org.springframework.stereotype.Service;

@Service
public class Repo1 {

    public String op1(String in) {
        return String.format("Operation 1 done on input: %s", in);
    }

    public String op2(String in) {
        return String.format("Operation 2 done on input: %s", in);
    }
}
