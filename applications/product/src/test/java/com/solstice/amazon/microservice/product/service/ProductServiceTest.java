package com.solstice.amazon.microservice.product.service;

import com.solstice.amazon.microservice.product.model.Product;
import com.solstice.amazon.microservice.product.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ProductServiceTest
{
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProduct()
    {
        Product product = new Product(1, "Snickers",
                "Candy bar", "Snickers Image", 3.50);

        when(productRepository.save(product)).thenReturn(product);

        assertEquals("Snickers", product.getName());
    }

    @Test
    public void getAllProducts()
    {
        Product product1 = new Product(1, "Snickers",
                "Candy bar", "Snickers Image", 3.50);

        Product product2 = new Product(1, "Snickers",
                "Candy bar", "Snickers Image", 3.50);

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);

        when(productRepository.findAll()).thenReturn(productList);

        verify(productRepository.findAll());

        assertEquals(productRepository.count(), productList.size());
    }

    @Test
    public void getOneProduct()
    {
        Product product = new Product(2, "Skittles", "Candy",
                "Snickers Image", 2.50);

        when(productRepository.getOne(product.getProductId())).thenReturn(product);

        assertEquals(productRepository.getOne(product.getProductId()).getName(),
                product.getName());

        verify(productRepository.getOne(product.getProductId()));
    }

    @Test
    public void updateProduct()
    {
        Product product = new Product(1, "Snickers",
                "Candy bar", "Snickers Image", 3.50);

        when(productRepository.save(product)).thenReturn(product);

        assertEquals("Snickers", product.getName());
    }

    @Test
    public void deleteProduct()
    {
        Product product = new Product(1, "Milky Way",
                "Choclate candy bar", "Snickers Image", 2.00);

        verify(productRepository).deleteById(anyInt());

    }


}
