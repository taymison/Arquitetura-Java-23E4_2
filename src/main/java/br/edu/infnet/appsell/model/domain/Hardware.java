package br.edu.infnet.appsell.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hardwares")
public class Hardware extends Product {
    private String brand;
    private int warrantyMonths;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s", super.toString(), brand, warrantyMonths);
    }
}
