package oop.shcherbak.model.client.impls;

import oop.shcherbak.model.client.interfaces.IClient;
// видані автомобілі

/**
 * Created by Kolja on 01.06.2017.
 */
public class Client implements IClient{
    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private String adress;
    private String phone;


    public Client() {
    }

    public Client(int id, String surname, String name, String fatherName, String adress, String phone) {

        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.adress = adress;
        this.phone = phone;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo(){
         return surname + " "+ name+" "+fatherName;
     }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", adress='" + adress + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}