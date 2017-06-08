package oop.shcherbak.dao.order.impls;

import oop.shcherbak.dao.order.interfaces.IOrderDao;
import oop.shcherbak.model.order.impls.Order;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by Kolja on 01.06.2017.
 */

public class DBOrderDao implements IOrderDao {
    private static Order temp;
    private List<Order> orders;
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public DBOrderDao() {
    }

    public DBOrderDao(DataSource dataSource) {

        this.dataSource = dataSource;
        JdbcTemplate select = new JdbcTemplate(dataSource);
        orders = select.query("SELECT * FROM orders", new OrderRowMapper(dataSource));
    }

    public DBOrderDao(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public Order getOrder(int id) {
        return (orders).stream().filter(p->p.getId().intValue()== id).findFirst().get();
    }

    @Override
    public void createOrder(Order order) {
        orders.add(order);

    }

    @Override
    public void deleteOrder(Integer id) {
        temp = null;
        orders.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        orders.remove(temp);
    }

    @Override
    public void updateOrder(Integer id, Order order) {
        temp = null;
        orders.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        orders.set(orders.indexOf(temp), order);
    }

    }



