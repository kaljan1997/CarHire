package oop.shcherbak.services.order.impls;

import oop.shcherbak.dao.order.impls.DBOrderDao;
import oop.shcherbak.dao.order.interfaces.IOrderDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.order.impls.Order;
import oop.shcherbak.services.order.interfaces.IServiceOrder;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kolja on 08.06.2017.
 */
public class ServiceOrderTest {
    IServiceOrder service;
    IOrderDao dao;
    public ServiceOrderTest() {
        List<Order> list = new ArrayList<>();
        list.add(new Order(new Car(1,"автобус","Mercedes Sprinter",0.0),new Client(1,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"), new Date(),new Date(),1));
        list.add(new Order(new Car(2,"автобус","Mercedes Sprinter",0.0),new Client(2,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"), new Date(),new Date(),2));
        list.add(new Order(new Car(3,"автобус","Mercedes Sprinter",0.0),new Client(3,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"), new Date(),new Date(),3));
        dao = new DBOrderDao(list);
        service = new ServiceOrder(dao);
    }
    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());

    }

    @Test
    public void getOrder() throws Exception {
        Assert.assertEquals(1,service.getOrder(1).getId().intValue());
    }

    @Test
    public void createOrder() throws Exception {
        service.createOrder(new Order(new Car(1,"автобус","Mercedes Sprinter",0.0),new Client(1,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"), new Date(),new Date(),4));
        Assert.assertEquals(4,service.getOrder(4).getId().intValue());

    }

    @Test
    public void deleteOrder() throws Exception {
        int size  = service.getAll().size();
        service.deleteOrder(2);
        Assert.assertEquals(true,size>service.getAll().size());
    }

    @Test
    public void updateOrder() throws Exception {
        service.updateOrder(3,new Order(new Car(5,"автобус","Mercedes Sprinter",0.0),new Client(1,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"), new Date(),new Date(),5));
        Assert.assertEquals(5,service.getOrder(5).getId().intValue());

    }

    @Test
    public void getPopularCar() throws Exception {

    }

    @Test
    public void getNotPopularCar() throws Exception {

    }

    @Test
    public void getHighPrice() throws Exception {

    }

    @Test
    public void getLowerPrice() throws Exception {

    }

    @Test
    public void getVipClient() throws Exception {

    }

}