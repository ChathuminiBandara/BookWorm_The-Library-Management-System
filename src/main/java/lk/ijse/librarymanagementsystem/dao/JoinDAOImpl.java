package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class JoinDAOImpl {
    public List<Object[]> getBlackListUsers(){
        Session session = null;
        List<Object[]> resultList = null;
        try {
            session = FactoryConfiguration.getFactoryConfiguration().getSession();
            resultList = session.createNativeQuery("select bd.id ,bd.dueDate,b.id,b.title,u.id, u.username, u.email  from borrowingdetails bd join User u on bd.User_id = u.id join Book b on bd.book_id = b.id where dueDate > '2024-03-06' AND bd.status = 'Not Returned'").getResultList();
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR).show();
        }finally {
            session.close();
        }
        return resultList;
    }
}
