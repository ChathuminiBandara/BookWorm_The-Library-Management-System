package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public interface BorrowingDAO extends CrudDAO<BorrowingDetails> {

     List<BorrowingDetails> getDetailsBYid(int id) ;

     boolean updateDueDate(int id);

     boolean updateStatus(int id);
}
