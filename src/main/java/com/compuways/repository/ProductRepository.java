package com.compuways.repository;

import com.compuways.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Product findByCode(String productCode);

    @Override
    List<Product> findAll();
}
