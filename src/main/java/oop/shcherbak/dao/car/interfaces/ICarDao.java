package oop.shcherbak.dao.car.interfaces;

import oop.shcherbak.model.car.impls.Car;

import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface ICarDao {
    List<Car> getAll();
    Car getCar(Integer id);
    void createCar(Car car);
    void deleteCar(Integer id);
    void updateCar(Integer id,Car car);
}
