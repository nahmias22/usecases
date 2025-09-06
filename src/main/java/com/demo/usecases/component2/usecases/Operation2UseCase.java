package com.demo.usecases.component2.usecases;

import com.demo.usecases.common.AbstractUseCase;
import com.demo.usecases.common.UseCaseContext;
import com.demo.usecases.component2.model.Operation2;

import static com.demo.usecases.common.ContextAttributes.*;


public class Operation2UseCase extends AbstractUseCase<Operation2UseCase.Input> {

    @Override
    public UseCaseContext<Input> execute(UseCaseContext<Input> ctx) {

        ctx.attr(OP_3_RESULT, dataCtx.repo2.op3(ctx.getInput().input.in1()));
        ctx.attr(OP_4_RESULT, dataCtx.repo2.op4(ctx.getInput().input.in2()));

        return ctx;
    }

    public record Input(Operation2 input){}
}
