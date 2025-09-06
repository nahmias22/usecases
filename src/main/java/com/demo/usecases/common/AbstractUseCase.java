package com.demo.usecases.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUseCase<I> {

    protected Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    protected DataContext dataCtx;

    public abstract UseCaseContext<I> execute(UseCaseContext<I> ctx);
}
