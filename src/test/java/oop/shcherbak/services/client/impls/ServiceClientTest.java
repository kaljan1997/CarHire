package oop.shcherbak.services.client.impls;

import oop.shcherbak.dao.client.impls.DBClientDao;
import oop.shcherbak.dao.client.interfaces.IClientDao;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.services.client.interfaces.IServiceClient;
import org.junit.Assert;
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
        list.add(new Client(1,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"));
        list.add(new Client(2,"Король","Володимир","Михайлович","380507754130","Чернівецька обл. Заставнівський р-н с. Товтри вул. Шкільна, 2"));
        list.add(new Client(3,"Барабаш","Іван","Васильович","380663347167","Чернівецька обл. Заставнівський р-н с. Товтри вул. Болотна, 6"));
        dao = new DBClientDao(list);
        service = new ServiceClient(dao);
    }
    @Test
    public void getAll() throws Exception {
        Assert.assertEquals(3,service.getAll().size());

    }

    @Test
    public void getClient() throws Exception {
        Assert.assertEquals("Заєць",service.getClient(1).getSurname().intern());
    }

    @Test
    public void createClient() throws Exception {
        service.createClient(new Client(4,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"));
        Assert.assertEquals(4,service.getClient(4).getId());
    }

    @Test
    public void deleteClient() throws Exception {
        int size  = service.getAll().size();
        service.deleteClient(2);
        Assert.assertEquals(true,size>service.getAll().size());


    }

    @Test
    public void updateClient() throws Exception {
        service.updateClient(3,new Client(5,"Заєць","Іванна","Василівна","380508459745","м. Чернівці вул. Калинівська, 18"));
        Assert.assertEquals(5,service.getClient(5).getId());
    }

}