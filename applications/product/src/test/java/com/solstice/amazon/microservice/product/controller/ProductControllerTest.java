package com.solstice.amazon.microservice.product.controller;

import com.solstice.amazon.microservice.product.model.Product;
import com.solstice.amazon.microservice.product.service.ProductService;
import com.sun.org.apache.xerces.internal.parsers.SecurityConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
@ContextConfiguration(classes = {SecurityConfiguration.class})
public class ProductControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addProduct() throws Exception
    {
        Product product = new Product(1, "Gummy Bears",
                "Candy", "Gummy Bears Image", 1.50);

        when(productService.addProduct(product)).thenReturn(new ResponseEntity(HttpStatus.CREATED));

        mockMvc
                .perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    public void getAllProducts() throws Exception
    {
        Product product1 = new Product(1, "Gummy Bears",
                "Candy", "Gummy Bears Image", 1.50);
        Product product2 = new Product(2, "Trident",
                "Chewing gum", "Trident Image", 1.67);
        Product product3 = new Product(3, "Reeses",
                "Chocolate & Peanut Butter Candy", "Reeses Image", 2.75);


        List<Product> productList = new ArrayList<>();

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);


        when(productService.getAllProducts()).thenReturn(productList);

        mockMvc
                .perform(get("/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }




}
