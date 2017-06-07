package oop.shcherbak.dao.issued.impls;

import oop.shcherbak.dao.issued.interfaces.IIssuedDao;
import oop.shcherbak.model.issued.impls.Issued;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;


/**
 * Created by Kolja on 01.06.2017.
 */
public class DBIssuedDao implements IIssuedDao {
    private DataSource dataSource;
    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public DBIssuedDao() {
    }

    public DBIssuedDao(DataSource dataSource) {

        this.dataSource = dataSource;
    }

    @Override
    public List<Issued> getAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select.query("SELECT * FROM issueds", new IssuedRowMapper(dataSource));
    }

    @Override
    public Issued getById(int id) {
        return null;
    }


}
