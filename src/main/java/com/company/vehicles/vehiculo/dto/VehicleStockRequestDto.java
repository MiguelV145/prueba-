package com.company.vehicles.vehiculo.dto;

public class VehicleStockRequestDto {
    
    public Long id;
    public Integer stock;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
}
