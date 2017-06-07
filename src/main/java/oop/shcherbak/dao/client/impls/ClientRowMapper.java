package oop.shcherbak.dao.client.impls;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class ClientRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ClientResultSetExtractor extractor = new ClientResultSetExtractor();
        return extractor.extractData(resultSet);
    }
}
