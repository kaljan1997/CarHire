package oop.shcherbak.dao.car.impls;


import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class CarRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ResultSetExtractor resultSetExtractor = new CarResultSetExtractor();

        return resultSetExtractor.extractData(resultSet);
    }
}
