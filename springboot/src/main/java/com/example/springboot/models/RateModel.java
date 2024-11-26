package com.example.springboot.models;

import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table (name = "TB_RATE")
public class RateModel extends RepresentationModel<RateModel> implements Serializable {
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID idRate;
    private String name;
    private int quantity;
    private BigDecimal allRate;
    private String idProduct;

    public UUID getIdRate() {
        return idRate;
    }

    public void setIdRate(UUID idRate) {
        this.idRate = idRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getAllRate() {
        return allRate;
    }

    public void setAllRate(BigDecimal allRate) {
        this.allRate = allRate;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }
}
