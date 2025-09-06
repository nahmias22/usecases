package com.demo.usecases.component1.usecases;

import com.demo.usecases.common.AbstractUseCase;
import com.demo.usecases.common.UseCaseContext;
import com.demo.usecases.component1.model.Operation1;

import static com.demo.usecases.common.ContextAttributes.OP_1_RESULT;
import static com.demo.usecases.common.ContextAttributes.OP_2_RESULT;


public class Operation1UseCase extends AbstractUseCase<Operation1UseCase.Input> {

    @Override
    public UseCaseContext<Input> execute(UseCaseContext<Input> ctx) {

        ctx.attr(OP_1_RESULT, dataCtx.repo1.op1(ctx.getInput().input.partA()));
        ctx.attr(OP_2_RESULT, dataCtx.repo1.op2(ctx.getInput().input.partB()));

        return ctx;
    }

    public record Input(Operation1 input){}
}
