package com.solstice.amazon.microservice.shipment.model;

public class Product
{
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

    public void setProductId(Integer productId)
    {
        this.productId = productId;
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
