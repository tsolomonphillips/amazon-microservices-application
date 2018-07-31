package com.solstice.amazon.microservice.product.controller;

import com.solstice.amazon.microservice.product.model.Product;
import com.solstice.amazon.microservice.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController
{
    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    @PostMapping("")
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        productService.addProduct(product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Integer productId)
    {
        return productService.getOneProduct(productId);
    }

    @PutMapping("{productId}")
    public ResponseEntity updateProduct(@PathVariable Integer productId, @RequestBody Product product)
    {
        productService.updateProduct(productId, product);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId)
    {
        productService.deleteProduct(productId);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
