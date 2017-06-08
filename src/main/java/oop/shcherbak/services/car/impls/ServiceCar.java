package oop.shcherbak.services.car.impls;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.car.interfaces.ICarDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.services.car.interfaces.IServiceCar;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Kolja on 07.06.2017.
 */
public class ServiceCar  implements IServiceCar{
    ICarDao dao;

    public ServiceCar(DataSource dataSource) {
        dao = new DBCarDao(dataSource);

    }

    public ServiceCar(ICarDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Car> getAll() {
        return dao.getAll();
    }

    @Override
    public Car getCar(Integer id) {
        return dao.getCar(id);
    }

    @Override
    public void createCar(Car car) {
        dao.createCar(car);

    }

    @Override
    public void deleteCar(Integer id) {
        dao.deleteCar(id);

    }

    @Override
    public void updateCar(Integer id, Car car) {
        dao.updateCar(id, car);

    }
}
