package com.solstice.amazon.microservice.product.model;

import javax.persistence.*;

@Entity
@Table(name = "productdb")
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Integer productId;

    private String name;
    private String description;
    private String image;
    private Double price;

    public Product()
    {

    }

    public Product(Integer productId, String name, String description,
                   String image, Double price)
    {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
    }

    public Integer getProductId()
    {
        return productId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
