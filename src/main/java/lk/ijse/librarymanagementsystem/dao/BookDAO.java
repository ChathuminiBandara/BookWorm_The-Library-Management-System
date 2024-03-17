package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public interface BookDAO extends CrudDAO<Book>{
     List<Book> getBooksFilterWithGenre(String genre) ;

     boolean updateBook(int id , String status);

     Book getBookByID(int id) ;

     boolean deleteBook(String id);

     boolean Update(Book book);
}
