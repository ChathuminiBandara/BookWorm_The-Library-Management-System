package lk.ijse.librarymanagementsystem.dao.impl;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.dao.UserDAO;
import lk.ijse.librarymanagementsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public User getUserByID(int id){
        Session session = null;
        User user = new User();
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from User where id = : ID");
            query.setParameter("ID",id);
            List<User> resultList = query.getResultList();
            user.setId(resultList.get(0).getId());
            user.setUsername(resultList.get(0).getPassword());
            user.setPassword(resultList.get(0).getPassword());
            user.setEmail(resultList.get(0).getEmail());
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return user;
    }

    @Override
    public List<User> getAll(){
        Session session = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            return session.createQuery("from User ").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant load Users").show();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean saveAll(User user) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(user);
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR ,  "Cant save User now").show();
        }finally {
            session.close();
        }
        return x > 0;
    }

    @Override
    public boolean updateUser(User user) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            session.update(user);
            x = 1 ;
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"Cant update User").show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }
    @Override
    public Long getUserCount(){
        Session session = null;
        Long count = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query<Long> query = session.createQuery("select count(id) from User", Long.class);
            count = query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
        return count;
    }
}
