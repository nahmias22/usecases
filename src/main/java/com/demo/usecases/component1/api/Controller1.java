package com.demo.usecases.component1.api;

import com.demo.usecases.common.UseCaseExecutor;
import com.demo.usecases.component1.model.Operation1;
import com.demo.usecases.component1.usecases.Operation1UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.usecases.common.ContextAttributes.OP_1_RESULT;
import static com.demo.usecases.common.ContextAttributes.OP_2_RESULT;

@RestController
@RequestMapping("/api/business1")
public class Controller1 {

    @Autowired
    private UseCaseExecutor executor;

    @PostMapping("/operation1")
    public String operation1(@RequestBody Operation1 input) {
        return executor.invoke(new Operation1UseCase.Input(input),
                ctx -> ((String) ctx.attr(OP_1_RESULT)).concat(" - ").concat((String) ctx.attr(OP_2_RESULT)));
    }

}
