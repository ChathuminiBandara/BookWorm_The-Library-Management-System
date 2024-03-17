package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;

import java.util.ArrayList;
import java.util.List;

public interface BookService extends AllService{
     Book getBookUsingID(int id);
     boolean updateBookStatus(int id ,String status);

     boolean saveBook(BookDTO bookDTO);
     ArrayList<BookDTO> getAllBooks();
     ArrayList<BookDTO> getBooksFilterWithGenre(String genre);

     boolean deleteBook(String id);

     boolean updateBook(BookDTO bookDTO);
      Long getBookCount();
}
