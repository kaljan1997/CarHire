package oop.shcherbak.dao.car.impls;

import oop.shcherbak.model.car.impls.Car;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Kolja on 01.06.2017.
 */
public class CarResultSetExtractor implements ResultSetExtractor{

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setType(resultSet.getString("type"));
        car.setBrand(resultSet.getString("brand"));
        car.setPrice(resultSet.getDouble("price"));
        car.setHirePrice(resultSet.getDouble("hire_price"));
        return car;
    }
}
