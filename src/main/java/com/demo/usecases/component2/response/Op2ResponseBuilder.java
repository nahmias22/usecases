package com.demo.usecases.component2.response;

import com.demo.usecases.common.UseCaseContext;

import static com.demo.usecases.common.ContextAttributes.OP_3_RESULT;
import static com.demo.usecases.common.ContextAttributes.OP_4_RESULT;

public class Op2ResponseBuilder {

    public static String build(UseCaseContext ctx) {
        return "Completed Operation 2. \n Tasks Performed: \n"
                .concat(" - ").concat((String) ctx.attr(OP_3_RESULT)).concat("\n")
                .concat(" - ").concat((String) ctx.attr(OP_4_RESULT)).concat("\n");
    }
}
