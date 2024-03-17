package lk.ijse.librarymanagementsystem.dao;

import lk.ijse.librarymanagementsystem.entity.Book;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    boolean saveAll(T t);
    List<T> getAll();
}
