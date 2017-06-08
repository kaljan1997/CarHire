package oop.shcherbak.dao.order.impls;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class OrderRowMapper implements RowMapper {
    DataSource dataSource;

    public OrderRowMapper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ResultSetExtractor extractor = new OrderResultSetExtractor(dataSource);
        return extractor.extractData(resultSet);
    }
}