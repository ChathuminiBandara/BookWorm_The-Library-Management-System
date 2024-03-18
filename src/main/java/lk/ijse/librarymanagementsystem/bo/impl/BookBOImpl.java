package lk.ijse.librarymanagementsystem.bo.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.BookDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BookDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.bo.BookBO;

import java.util.ArrayList;
import java.util.List;

public class BookBOImpl implements BookBO {

    BookDAOImpl bookDAO = (BookDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOK);

    @Override
    public Book getBookUsingID(int id){
        return bookDAO.getBookByID(id);
    }

    @Override
    public boolean updateBookStatus(int id ,String status){
        return bookDAO.updateBook(id,status);
    }

    @Override
    public boolean saveBook(BookDTO bookDTO){
        return bookDAO.saveAll(new Book(bookDTO.getId(), bookDTO.getTitle(), bookDTO.getAuthor(),
                bookDTO.getGenre(), bookDTO.getStatus(), bookDTO.getUrl(),new ArrayList<>()));
    }

    @Override
    public ArrayList<BookDTO> getAllBooks(){
        List<Book> allBooks = bookDAO.getAll();
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        for (Book b : allBooks){
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<BookDTO> getBooksFilterWithGenre(String genre){
        List<Book> allBooks = bookDAO.getBooksFilterWithGenre(genre);
        ArrayList<BookDTO> arrayList = new ArrayList<>();
        for (Book b : allBooks){
            arrayList.add(new BookDTO(b.getId(),b.getTitle(),b.getAuthor(),b.getGenre(),b.getStatus(),b.getUrl()));
        }
        return arrayList;
    }

    @Override
    public boolean deleteBook(String id) {
        return bookDAO.deleteBook(id);
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        return bookDAO.Update(new Book(bookDTO.getId(),bookDTO.getTitle(),bookDTO.getAuthor(),bookDTO.getGenre(),bookDTO.getStatus(),bookDTO.getUrl(),new ArrayList<>()));
    }

    @Override
    public Long getBookCount(){
        Long bookCount = bookDAO.getBookCount();
        return bookCount;
    }
}
