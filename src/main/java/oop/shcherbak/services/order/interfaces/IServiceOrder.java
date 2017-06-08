package oop.shcherbak.services.order.interfaces;

import oop.shcherbak.dao.order.interfaces.IOrderDao;
import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;

/**
 * Created by Kolja on 07.06.2017.
 */
public interface IServiceOrder extends IOrderDao {
    Car getPopularCar();
    Car getNotPopularCar();
    Car getHighPrice();
    Car getLowerPrice();
    Client getVipClient();
}
