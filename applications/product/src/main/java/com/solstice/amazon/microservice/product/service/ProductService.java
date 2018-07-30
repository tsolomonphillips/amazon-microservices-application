package com.solstice.amazon.microservice.product.service;

import com.solstice.amazon.microservice.product.model.Product;
import com.solstice.amazon.microservice.product.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService
{
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    public ResponseEntity addProduct(Product product)
    {
        productRepository.save(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public Product getOneProduct(Integer productId)
    {
        return productRepository.getOne(productId);
    }

    public ResponseEntity updateProduct(Integer productId, Product product)
    {
        Product productToUpdate = productRepository.getOne(productId);
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setImage(product.getImage());
        productToUpdate.setPrice(product.getPrice());

        productRepository.save(productToUpdate);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteProduct(Integer productId)
    {
        productRepository.deleteById(productId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
