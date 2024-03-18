package lk.ijse.librarymanagementsystem.bo;

import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;

import java.util.ArrayList;

public interface BookBO extends superBo {
     Book getBookUsingID(int id);
     boolean updateBookStatus(int id ,String status);

     boolean saveBook(BookDTO bookDTO);
     ArrayList<BookDTO> getAllBooks();
     ArrayList<BookDTO> getBooksFilterWithGenre(String genre);

     boolean deleteBook(String id);

     boolean updateBook(BookDTO bookDTO);
      Long getBookCount();
}
