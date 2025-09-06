package com.demo.usecases.common;

import com.demo.usecases.repo.Repo1;
import com.demo.usecases.repo.Repo2;

public class DataContext {

    public Repo1 repo1;

    public Repo2 repo2;

    public DataContext() {
    }

    public DataContext(Repo1 repo1, Repo2 repo2) {
        this.repo1 = repo1;
        this.repo2 = repo2;
    }
}
