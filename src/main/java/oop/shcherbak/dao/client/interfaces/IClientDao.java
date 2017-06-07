package oop.shcherbak.dao.client.interfaces;

import oop.shcherbak.model.client.impls.Client;

import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface IClientDao {
    List<Client> getAll();
    Client getClient(Integer id);
    void createClient(Client client);
    void deleteClient(Integer id);
    void updateClient(Integer id,Client client);
}
