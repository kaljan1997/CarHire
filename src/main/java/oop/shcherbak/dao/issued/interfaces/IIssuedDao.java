package oop.shcherbak.dao.issued.interfaces;

import oop.shcherbak.model.issued.impls.Issued;

import java.util.List;

/**
 * Created by Kolja on 01.06.2017.
 */
public interface IIssuedDao {
    List<Issued> getAll();
    Issued getIssued(int id);
    void createIssued(Issued issued);
    void deleteIssued(Integer id);
    void updateIssued(Integer id,Issued issued);
}
