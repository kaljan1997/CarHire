package oop.shcherbak.controller;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.issued.impls.DBIssuedDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.issued.impls.Issued;
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
    @RequestMapping ("/issued")
    public  List<Issued> getIssued(){
        DBIssuedDao dao = new DBIssuedDao(dataSource);
        return dao.getAll();
    }
    @RequestMapping ("/cars")
    public List <Car> getCars(){
        DBCarDao dao = new DBCarDao();
        dao.setDataSource(dataSource);
        return dao.getAll();
    }
    @RequestMapping ("/client")
    public List<Client> getClients() {
        DBClientDao dao = new DBClientDao(dataSource);
        return dao.getAll();
    }
}
