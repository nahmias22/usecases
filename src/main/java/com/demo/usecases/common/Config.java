package com.demo.usecases.common;

import com.demo.usecases.component1.usecases.Operation1UseCase;
import com.demo.usecases.component2.usecases.Operation2UseCase;
import com.demo.usecases.repo.Repo1;
import com.demo.usecases.repo.Repo2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {

    @Bean
    public UseCaseExecutor useCaseExecutor(List<AbstractUseCase<?>> useCases) {
        return new UseCaseExecutor(useCases);
    }

    @Bean
    public DataContext dataContext(Repo1 repo1, Repo2 repo2){
        return new DataContext(repo1, repo2);
    }

    @Bean
    public Operation1UseCase operation1UseCase() {
        return new Operation1UseCase();
    }

    @Bean
    public Operation2UseCase operation2UseCase() {
        return new Operation2UseCase();
    }
}
