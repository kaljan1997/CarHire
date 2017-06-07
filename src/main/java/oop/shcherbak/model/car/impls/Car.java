package oop.shcherbak.model.car.impls;

import oop.shcherbak.model.car.interfaces.ICar;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Kolja on 01.06.2017.
 */
@Entity
@Table(name = "cars")
public class Car implements ICar, Serializable{
    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "type")
    private String type;
    @Column(name = "brand")
    private String brand;
    @Column(name = "price")
    private Double price;
    @Column(name = "hire_price")
    private Double hirePrice;

    public Double getHirePrice() {
        return hirePrice;
    }

    public void setHirePrice(Double hirePrice) {
        this.hirePrice = hirePrice;
    }

    public Car() {
    }

    public Car(int id, String type, String brand, Double price) {

        this.id = id;
        this.type = type;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
