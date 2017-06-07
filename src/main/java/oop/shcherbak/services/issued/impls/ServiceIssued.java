package oop.shcherbak.services.issued.impls;

import oop.shcherbak.dao.issued.impls.DBIssuedDao;
import oop.shcherbak.dao.issued.interfaces.IIssuedDao;
import oop.shcherbak.model.issued.impls.Issued;
import oop.shcherbak.services.issued.interfaces.IServiceIssued;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Kolja on 07.06.2017.
 */
public class ServiceIssued implements IServiceIssued {
    public ServiceIssued(DataSource dataSource) {
        dao = new DBIssuedDao(dataSource);
    }

    IIssuedDao dao;

    @Override
    public List<Issued> getAll() {
        return dao.getAll();
    }

    @Override
    public Issued getIssued(int id) {
        return dao.getIssued(id);
    }

    @Override
    public void createIssued(Issued issued) {
        dao.createIssued(issued);
    }

    @Override
    public void deleteIssued(Integer id) {
        dao.deleteIssued(id);

    }

    @Override
    public void updateIssued(Integer id, Issued issued) {
        dao.updateIssued(id, issued);

    }
}
