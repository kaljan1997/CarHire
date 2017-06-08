package oop.shcherbak.services.car.impls;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.car.interfaces.ICarDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.services.car.interfaces.IServiceCar;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kolja on 08.06.2017.
 */
public class ServiceCarTest {

        IServiceCar service;
        ICarDao dao;

        public ServiceCarTest() {
            List<Car> list = new ArrayList<>();
            list.add(new Car(1,"автобус","Mercedes Sprinter",0.0));
            list.add(new Car(2,"седан","Lada 2109",0.0));
            list.add(new Car(3,"джип","Lada NIVA",0.0));
            dao = new DBCarDao(list);
            service = new ServiceCar(dao);
        }
    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());

    }

    @Test
    public void getCar() throws Exception {
        Assert.assertEquals("автобус",service.getCar(1).getType().intern());

    }

    @Test
    public void createCar() throws Exception {
        service.createCar(new Car(4,"автобус","Mercedes Sprinter",0.0));
        Assert.assertEquals(4,service.getCar(4).getId());

    }

    @Test
    public void deleteCar() throws Exception {
        int size  = service.getAll().size();
        service.deleteCar(2);
        Assert.assertEquals(true,size>service.getAll().size());


    }

    @Test
    public void updateCar() throws Exception {
        service.updateCar(3,new Car(5,"автобус","Mercedes Sprinter",0.0));
        Assert.assertEquals(5,service.getCar(5).getId());

    }

}