package com.company.vehicles.vehiculo.entities;

public class Vehiclee {

    public Long id;
    public String brand;
    public String model ;
    public Double price;
    public Integer  stock;
    public String deletd;

    public Vehiclee(Long id, String brand, String model, Double price, Integer stock) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.deletd = deletd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDeletd() {
        return deletd;
    }

    public void setDeletd(String deletd) {
        this.deletd = deletd;
    }

    
    
    
}
