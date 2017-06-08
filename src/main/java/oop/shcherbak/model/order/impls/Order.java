package oop.shcherbak.model.order.impls;

import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.order.interfaces.IOrder;

import java.util.Date;

/**
 * Created by Kolja on 01.06.2017.
 */
public class Order implements IOrder {
    private Integer id;
    private Car car;
    private Client client;
    private Date dateOrder;
    private Date returnDate;

    public Order() {
    }

    public Order(Car car, Client client, Date dateOrder, Date returnDate, Integer id) {
        this.id = id;
        this.car = car;
        this.client = client;
        this.dateOrder = dateOrder;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "car=" + car +
                ", client=" + client +
                ", dateOrder=" + dateOrder +
                ", returnDate=" + returnDate +
                '}';
    }
}
