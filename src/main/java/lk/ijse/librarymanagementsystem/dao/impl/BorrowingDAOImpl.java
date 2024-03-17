package lk.ijse.librarymanagementsystem.dao.impl;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.dao.BorrowingDAO;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class BorrowingDAOImpl implements BorrowingDAO {

    @Override
    public boolean saveAll(BorrowingDetails borrowingDetails){
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            x = (int) session.save(borrowingDetails);
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR,"cant reservate book!!").show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }

    @Override
    public List<BorrowingDetails> getAll() {
        return null;
    }

    @Override
    public List<BorrowingDetails> getDetailsBYid(int id) {
        Session session = null;
        List<BorrowingDetails> list = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Query query = session.createQuery("from BorrowingDetails where User.id = :ID");
            query.setParameter("ID",id);
            list = query.getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return list;
    }

    @Override
    public boolean updateDueDate(int id) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("UPDATE BorrowingDetails b set dueDate = :Date where id = :ID");
            query.setParameter("Date",String.valueOf(LocalDate.now()));
            query.setParameter("ID",id);
            x = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return x > 0 ;

    }

    @Override
    public boolean updateStatus(int id) {
        Session session = null;
        int x = 0 ;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("update BorrowingDetails b set status = :Status where id = :ID");
            query.setParameter("Status","Returned");
            query.setParameter("ID",id);
            x = query.executeUpdate();
            transaction.commit();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return x > 0 ;
    }
}
