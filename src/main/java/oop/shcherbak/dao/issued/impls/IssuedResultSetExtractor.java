package oop.shcherbak.dao.issued.impls;

import oop.shcherbak.dao.car.impls.DBCarDao;
import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.model.issued.impls.Issued;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Kolja on 01.06.2017.
 */
public class IssuedResultSetExtractor implements ResultSetExtractor{
    DataSource dataSource;
    DBCarDao carDao;
    DBClientDao clientDao;

    public IssuedResultSetExtractor(DataSource dataSource) {
        this.dataSource = dataSource;
        carDao = new DBCarDao(dataSource);
        clientDao = new DBClientDao(dataSource);
    }

    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Issued issued = new Issued();
        issued.setCar(carDao.getCar(resultSet.getInt("car_id")));
        issued.setClient(clientDao.getClient(resultSet.getInt("client_id")));
        issued.setDateIssue(resultSet.getDate("date_issue"));
        issued.setReturnDate(resultSet.getDate("return_date"));
        return issued;
    }
}
