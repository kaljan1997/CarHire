package oop.shcherbak.model.client.interfaces;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface IClient {
    int getId();
    void setId(int id);
    String getSurname();
    void setSurname(String surname);
    String getName();
    void setName(String name);
    String getFatherName();
    void setFatherName(String fatherName);
    String getAdress();
    void setAdress(String adress);
    String getPhone();
    void setPhone(String phone);
    String getInfo();
}
