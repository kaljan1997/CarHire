package oop.shcherbak.dao.order.interfaces;

import oop.shcherbak.model.order.impls.Order;

import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface IOrderDao {
    List<Order> getAll();
    Order getOrder(int id);
    void createOrder(Order order);
    void deleteOrder(Integer id);
    void updateOrder(Integer id, Order order);
}
