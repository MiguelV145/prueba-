package com.company.vehicles.models;

import java.time.LocalDateTime;

import com.company.vehicles.vehiculo.dto.VehicleResponseDto;
import com.company.vehicles.vehiculo.dto.VehicleStockRequestDto;
import com.company.vehicles.vehiculo.entities.VehicleEntity;

public class Vehicle {

    private Long id;
    private String brand;
    private String model;
    private Double price;
    private Integer stock;
    
    private LocalDateTime createdAt;

    public Vehicle(Long id, String brand, String model, Double price, Integer stock) {
        if (brand == null || brand.isBlank())
            throw new IllegalArgumentException("Marca inválida");

        if (model == null || model.isBlank())
            throw new IllegalArgumentException("Modelo inválido");

        if (price == null || price <= 0)
            throw new IllegalArgumentException("Precio inválido");

        if (stock == null || stock < 0)
            throw new IllegalArgumentException("Stock inválido");

        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.stock = stock;
        this.createdAt = LocalDateTime.now();
    }

    // ==================== GETTERS AND SETTERS ====================

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // ==================== FACTORY METHODS ====================

    /**
     * Crea un Vehicle desde una entidad persistente
     * @param entity Entidad recuperada de la BD
     * @return instancia de Vehicle para lógica de negocio
     */
    public static Vehicle fromEntity(VehicleEntity entity) {
        return new Vehicle(
            entity.getId(),
            entity.getBrand(),
            entity.getModel(),
            entity.getPrice(),
            entity.getStock()
        );
    }

    // ==================== CONVERSION METHODS ====================

    /**
     * Convierte este Vehicle a una entidad persistente
     * @return VehicleEntity lista para guardar en BD
     */
    public VehicleEntity toEntity() {
        VehicleEntity entity = new VehicleEntity();

        // Si ya tiene id, lo asignamos (para updates)
        if (this.id > 0) {
            entity.setId(this.id);
        }

        entity.setBrand(this.brand);
        entity.setModel(this.model);
        entity.setPrice(this.price);
        entity.setStock(this.stock);
        return entity;
    }

    /**
     * Convierte este Vehicle a un DTO de respuesta
     * @return DTO con información del vehículo
     */
    public VehicleResponseDto toResponseDto() {
        return new VehicleResponseDto(
            this.id,
            this.brand,
            this.model,
            this.price,
            this.stock
        );
    }

    /**
     * Actualiza el stock del vehículo
     * @param dto DTO con el nuevo stock
     * @return esta instancia de Vehicle
     */
    public Vehicle updateStock(VehicleStockRequestDto dto) {
        if (dto.stock == null || dto.stock < 0)
            throw new IllegalArgumentException("El stock no puede ser negativo");

        this.stock = dto.stock;
        return this;
    }

}
