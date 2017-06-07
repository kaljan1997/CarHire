package oop.shcherbak.dao.client.impls;

import oop.shcherbak.model.client.impls.Client;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class ClientResultSetExtractor implements ResultSetExtractor{
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Client client = new Client();
        client.setId(resultSet.getInt("id"));
        client.setSurname(resultSet.getString("surname"));
        client.setName(resultSet.getString("name"));
        client.setFatherName(resultSet.getString("father_name"));
        client.setPhone(resultSet.getString("phone"));
        client.setAdress(resultSet.getString("adress"));
        return client;
    }
}
