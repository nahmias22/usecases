package com.demo.usecases.component2.api;

import com.demo.usecases.common.UseCaseExecutor;
import com.demo.usecases.component2.model.Operation2;
import com.demo.usecases.component2.response.Op2ResponseBuilder;
import com.demo.usecases.component2.usecases.Operation2UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/business2")
public class Controller2 {

    @Autowired
    private UseCaseExecutor executor;

    @PostMapping("/operation2")
    public String operation2(@RequestBody Operation2 input) {
        return executor.invoke(new Operation2UseCase.Input(input),
                Op2ResponseBuilder::build);
    }

}
