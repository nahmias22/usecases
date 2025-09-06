package com.demo.usecases.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UseCaseExecutor {

    private final Logger log = LoggerFactory.getLogger(UseCaseExecutor.class);

    @SuppressWarnings("rawtypes")
    private final Map<Class, AbstractUseCase> registry;

    public UseCaseExecutor(List<AbstractUseCase<?>> cases) {
        this.registry = cases.stream()
                .collect(Collectors.toMap(
                        this::resolve,
                        useCase -> useCase
                ));
    }

//    @SuppressWarnings({"unchecked"})
    private <I> Class<I> resolve(AbstractUseCase<I> useCase) {
        Class<?>[] generics = GenericTypeResolver.resolveTypeArguments(useCase.getClass(), AbstractUseCase.class);
        assert generics != null;
//        assert generics[0] instanceof Class<I>;
        return (Class<I>) generics[0];
    }

    public <O, I> O invoke(I input, Function<UseCaseContext, Object> map) {
        AbstractUseCase<I> useCase = registry.get(input.getClass());
        log.info("Executing: {}", useCase.getClass().getSimpleName());

        UseCaseContext<I> ctx = new UseCaseContext<>(input);
        ctx.setMapper(map);
        return useCase.execute(ctx).map();
    }
}
