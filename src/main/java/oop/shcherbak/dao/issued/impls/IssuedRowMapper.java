package oop.shcherbak.dao.issued.impls;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class IssuedRowMapper implements RowMapper {
    DataSource dataSource;

    public IssuedRowMapper(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ResultSetExtractor extractor = new IssuedResultSetExtractor(dataSource);
        return extractor.extractData(resultSet);
    }
}