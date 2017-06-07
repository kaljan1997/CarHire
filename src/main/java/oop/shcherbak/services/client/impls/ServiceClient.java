package oop.shcherbak.services.client.impls;

import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.client.interfaces.IClientDao;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.services.client.interfaces.IServiceClient;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Kolja on 07.06.2017.
 */
public class ServiceClient implements IServiceClient{

    IClientDao dao;

    public ServiceClient(DataSource dataSource) {
        dao = new DBClientDao(dataSource);

    }

    @Override
    public List<Client> getAll() {
        return dao.getAll();
    }

    @Override
    public Client getClient(Integer id) {
        return dao.getClient(id);
    }

    @Override
    public void createClient(Client client) {
        dao.createClient(client);
    }

    @Override
    public void deleteClient(Integer id) {
dao.deleteClient(id);
    }

    @Override
    public void updateClient(Integer id, Client client) {
dao.updateClient(id,client);
    }
}
