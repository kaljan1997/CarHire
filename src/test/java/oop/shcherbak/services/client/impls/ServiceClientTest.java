package oop.shcherbak.services.client.impls;

import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.client.interfaces.IClientDao;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.services.client.interfaces.IServiceClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Kolja on 08.06.2017.
 */
public class ServiceClientTest {
    IServiceClient service;
    IClientDao dao;

    public ServiceClientTest() {
        List<Client> list = new ArrayList<>();
        list.add(new Client(1,"","","","",""));
        list.add(new Client(2,"","","","",""));
        list.add(new Client(3,"","","","",""));
        dao = new DBClientDao(list);
        service = new ServiceClient(dao);
    }
    @Test
    public void getAll() throws Exception {

    }

    @Test
    public void getClient() throws Exception {

    }

    @Test
    public void createClient() throws Exception {

    }

    @Test
    public void deleteClient() throws Exception {

    }

    @Test
    public void updateClient() throws Exception {

    }

}