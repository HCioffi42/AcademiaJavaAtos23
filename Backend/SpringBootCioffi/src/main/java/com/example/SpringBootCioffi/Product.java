package com.example.SpringBootCioffi;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private int code;
    @Column(length = 50)
    private String name;
    @Column(length = 50)
    private String color;
    @Column()
    private Float price;
    @Column()
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product(int code, String name, String color, Float price, int quantity) {
        super();
        this.code = code;
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString(){
        return "product [ID=" + id + ", Code=" + code + ", Name=" + name + ", Color=" + color + ", Price=" + price +
                ", Quantity=" + quantity + "]";
    }

    public Product() {
        super();
    }
}
