package oop.shcherbak.controller;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.order.impls.DBOrderDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.order.impls.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */

@RestController
public class Controller {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    public Controller() {
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/Car");
        dataSource.setUsername("root");
        dataSource.setPassword("worka841");
    }
    @RequestMapping ("/order")
    public  List<Order> getOrder(){
        DBOrderDao dao = new DBOrderDao(dataSource);
        return dao.getAll();
    }
    @RequestMapping ("/cars")
    public List <Car> getCars(){
        DBCarDao dao = new DBCarDao(dataSource);
        return dao.getAll();
    }
    @RequestMapping ("/client")
    public List<Client> getClients() {
        DBClientDao dao = new DBClientDao(dataSource);
        return dao.getAll();
    }
}
