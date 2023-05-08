package com.ltp.globalsuperstore;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

public class Item {
    private String category;
    private String name;
    private Double price;
    private Double discount;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date date;

    private  String id;

    public Item(String category, String name, Double price, Double discount, Date date) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.date = date;
    }

    public Item() {
        this.id=UUID.randomUUID().toString();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
