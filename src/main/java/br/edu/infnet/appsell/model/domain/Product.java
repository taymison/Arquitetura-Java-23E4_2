package br.edu.infnet.appsell.model.domain;

public class Product {
    private String description;
    private int code;
    private float price;
    private boolean stock;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStock() {
        return stock;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    public String toString() {
        return String.format("%s - %s - %s - %s", description, code, price, stock);
    }
}
