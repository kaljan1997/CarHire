package oop.shcherbak.model.car.interfaces;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface ICar {
    int getId();
    Double getHirePrice();
    void setId(int id);
    String getType();
    void setType(String type);
    String getBrand();
    void setBrand(String brand);
    Double getPrice();
    void setPrice(Double price);
    void setHirePrice(Double hirePrice);

}
