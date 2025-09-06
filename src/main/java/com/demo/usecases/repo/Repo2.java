package com.demo.usecases.repo;

import org.springframework.stereotype.Service;

@Service
public class Repo2 {

    public String op3(String in) {
        return String.format("Operation 3 done on input: %s", in);
    }

    public String op4(String in) {
        return String.format("Operation 4 done on input: %s", in);
    }
}
