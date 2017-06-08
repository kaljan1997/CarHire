package oop.shcherbak.dao.order.impls;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.model.order.impls.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class OrderResultSetExtractor implements ResultSetExtractor{
    DataSource dataSource;
    DBCarDao carDao;
    DBClientDao clientDao;

    public OrderResultSetExtractor(DataSource dataSource) {
        this.dataSource = dataSource;
        carDao = new DBCarDao(dataSource);
        clientDao = new DBClientDao(dataSource);
    }

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Order order = new Order();
        order.setId(resultSet.getInt("id"));
        order.setCar(carDao.getCar(resultSet.getInt("car_id")));
        order.setClient(clientDao.getClient(resultSet.getInt("client_id")));
        order.setDateOrder(resultSet.getDate("date_order"));
        order.setReturnDate(resultSet.getDate("return_date"));
        return order;
    }
}
