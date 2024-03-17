package lk.ijse.librarymanagementsystem.dao.impl;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.dao.AdminDAO;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminDAOImpl implements AdminDAO {

    @Override
    public List<Admin> getAll(){
        Session session = null;
        List<Admin> resultList = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            resultList = session.createQuery("from Admin ").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant load Admins").show();
        }finally {
            session.close();
            return resultList;
        }
    }

    @Override
    public boolean updateAdmin(Admin admin){
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(admin);
            transaction.commit();
            x = 1;
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant Update password now").show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }

    @Override
    public boolean saveAll(Admin admin) {
        Session session = null;
        int x = 0;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(admin);
            transaction.commit();
        }catch (Exception e ){
            new Alert(Alert.AlertType.ERROR,"Cant save Admin now").show();
        }finally {
            session.close();
        }
        return x > 0 ;

    }
}
