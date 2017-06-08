package oop.shcherbak.services.order.impls;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.car.interfaces.ICarDao;
import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.client.interfaces.IClientDao;
import oop.shcherbak.dao.order.impls.DBOrderDao;
import oop.shcherbak.dao.order.interfaces.IOrderDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.order.impls.Order;
import oop.shcherbak.services.order.interfaces.IServiceOrder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Kolja on 07.06.2017.
 */
public class ServiceOrder implements IServiceOrder {
    public ServiceOrder(DataSource dataSource) {
        orderDao = new DBOrderDao(dataSource);
        clientDao = new DBClientDao(dataSource);
        carDao = new DBCarDao(dataSource);
    }

    IOrderDao orderDao;
    IClientDao clientDao;
    ICarDao carDao;

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public Order getOrder(int id) {
        return orderDao.getOrder(id);
    }

    @Override
    public void createOrder(Order order) {
        orderDao.createOrder(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderDao.deleteOrder(id);

    }

    @Override
    public void updateOrder(Integer id, Order order) {
        orderDao.updateOrder(id, order);

    }
    private static Integer max;
    private static Integer temp_id;
    @Override
    public Car getPopularCar() {
        Map<Integer,Integer> map = new HashMap<>();
        orderDao.getAll().forEach(item->{
            if(map.containsKey(item.getCar().getId()))
                map.put(item.getCar().getId(),map.get(item.getCar().getId())+1);
            else {
                map.put(item.getCar().getId(),0);
            }
        });
        max = 0;
        map.values().forEach(p->{if(p>max)p=max;});
        temp_id=-1;
        map.forEach((k,v)->{
            if(v==max)
                temp_id = k;
        });
        return carDao.getCar(temp_id);
    }

    @Override
    public Car getNotPopularCar() {
        Map<Integer,Integer> map = new HashMap<>();
        orderDao.getAll().forEach(item->{
            if(map.containsKey(item.getCar().getId()))
                map.put(item.getCar().getId(),map.get(item.getCar().getId())+1);
            else {
                map.put(item.getCar().getId(),0);
            }
        });
        max = Integer.MAX_VALUE;
        map.values().forEach(p->{if(p<max)p=max;});
        temp_id=-1;
        map.forEach((k,v)->{
            if(v==max)
                temp_id = k;
        });
        return carDao.getCar(temp_id);
    }

    private static Double temp_double_price;
    private static Car temp_car;
    @Override
    public Car getHighPrice() {
        Map<Car,Double> map = new HashMap<>();
        carDao.getAll().forEach(p-> map.put(p,p.getPrice()));
        temp_double_price = 0.0;
        temp_car = null;
        map.forEach((k,v)->{
            if(v.doubleValue()>temp_double_price.doubleValue()){
                temp_double_price = v;
                temp_car = k;
            }
        });
        return temp_car;
    }

    @Override
    public Car getLowerPrice() {
        Map<Car,Double> map = new HashMap<>();
        carDao.getAll().forEach(p-> map.put(p,p.getPrice()));
        temp_double_price = Double.MAX_VALUE;
        temp_car = null;
        map.forEach((k,v)->{
            if(v.doubleValue()<temp_double_price.doubleValue()){
                temp_double_price = v;
                temp_car = k;
            }
        });
        return temp_car;
    }
    private static Client temp_client;
    @Override
    public Client getVipClient() {
        Map<Client,Double> map = new HashMap<>();
        orderDao.getAll().forEach(p->{
            if(map.containsValue(p.getClient()))
                map.put(p.getClient(),p.getCar().getHirePrice());
        });
        temp_double_price = 0.0;
        temp_client=null;
        map.forEach((k,v)->{
            if(v.doubleValue()>temp_double_price.doubleValue()){
                temp_double_price = v;
                temp_client = k;
            }
        });
        return temp_client;
    }

}
//найбільш використовувана машина
//найдешевша машина
//найдорожча машина
//віп клієнт
//Машина якою ніхто не цікавиться
