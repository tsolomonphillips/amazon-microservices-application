package com.solstice.amazon.microservice.product.repository;

import com.solstice.amazon.microservice.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
