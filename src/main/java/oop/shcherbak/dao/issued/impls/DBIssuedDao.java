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
    private static Issued temp;
    private List<Issued> issueds;
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    public DBIssuedDao() {
    }

    public DBIssuedDao(DataSource dataSource) {

        this.dataSource = dataSource;
        JdbcTemplate select = new JdbcTemplate(dataSource);
        issueds = select.query("SELECT * FROM issueds", new IssuedRowMapper(dataSource));
    }

    @Override
    public List<Issued> getAll() {
        return issueds;
    }

    @Override
    public Issued getIssued(int id) {
        return (issueds).stream().filter(p->p.getId().intValue()== id).findFirst().get();
    }

    @Override
    public void createIssued(Issued issued) {
        issueds.add(issued);

    }

    @Override
    public void deleteIssued(Integer id) {
        temp = null;
        issueds.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        issueds.remove(temp);
    }

    @Override
    public void updateIssued(Integer id, Issued issued) {
        temp = null;
        issueds.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        issueds.set(issueds.indexOf(temp),issued);
    }

    }



