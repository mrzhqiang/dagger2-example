package com.github.mrzhqiang.dagger2_example.data;

import java.util.List;
import java.util.Optional;

public interface DataSource<I, D> {

    List<D> findAll();

    Optional<D> findBy(I id);

    boolean save(D data);

    boolean deleteAll();

    boolean deleteBy(I id);
}
