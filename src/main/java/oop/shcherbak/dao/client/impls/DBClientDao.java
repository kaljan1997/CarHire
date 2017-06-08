package oop.shcherbak.dao.client.impls;

import oop.shcherbak.dao.client.interfaces.IClientDao;
import oop.shcherbak.model.client.impls.Client;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public class DBClientDao implements IClientDao{
    DataSource dataSource;
    private List<Client> clients;
    private static Client temp;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DBClientDao() {

    }

    public DBClientDao(DataSource dataSource) {

        this.dataSource = dataSource;
        JdbcTemplate select = new JdbcTemplate(dataSource);
        clients =  select.query("SELECT * FROM client", new ClientRowMapper());
    }
    public DBClientDao(List<Client> cars) {
        this.clients = cars;
    }

    @Override
    public List<Client> getAll() {
        return clients;
    }

    @Override
    public Client getClient(Integer id) {
        return clients.stream().filter(p->id.intValue()==p.getId()).findFirst().get();
    }

    @Override
    public void createClient(Client client) {
        clients.add(client);
    }

    @Override
    public void deleteClient(Integer id) {
        temp = null;
        clients.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        clients.remove(temp);
    }

    @Override
    public void updateClient(Integer id, Client client) {
        temp = null;
        clients.forEach(item->{
            if(item.getId()==id.intValue())
                temp = item;
        });
        clients.set(clients.indexOf(temp),client);
    }
}
