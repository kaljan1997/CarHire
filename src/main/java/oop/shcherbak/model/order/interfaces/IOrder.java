package oop.shcherbak.model.order.interfaces;

import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;

import java.util.Date;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface IOrder {
    Car getCar();
    void setCar(Car car);
    Client getClient();
    void setClient(Client client);
    Date getDateOrder();
    void setDateOrder(Date dateOrder);
    Date getReturnDate();
    void setReturnDate(Date returnDate);
    Integer getId();
    void setId(Integer id);


}
