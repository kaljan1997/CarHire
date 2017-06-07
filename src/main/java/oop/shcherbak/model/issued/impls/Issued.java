package oop.shcherbak.model.issued.impls;

import oop.shcherbak.model.car.impls.Car;
import oop.shcherbak.model.client.impls.Client;
import oop.shcherbak.model.issued.interfaces.IIssued;

import java.util.Date;

/**
 * Created by Kolja on 01.06.2017.
 */
public class Issued implements IIssued{
    private Integer id;
    private Car car;
    private Client client;
    private Date dateIssue;
    private Date returnDate;

    public Issued() {
    }

    public Issued(Car car, Client client, Date dateIssue, Date returnDate, Integer id) {
        this.id = id;
        this.car = car;
        this.client = client;
        this.dateIssue = dateIssue;
        this.returnDate = returnDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Issued{" +
                "car=" + car +
                ", client=" + client +
                ", dateIssue=" + dateIssue +
                ", returnDate=" + returnDate +
                '}';
    }
}
