package lk.ijse.librarymanagementsystem.service.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.BorrowingDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.entity.User;
import lk.ijse.librarymanagementsystem.service.BorrowingDetailsService;
import lk.ijse.librarymanagementsystem.service.ServiceFactory;

import java.util.List;

public class BorrowingDetailsServiceImpl implements BorrowingDetailsService {
    BorrowingDAOImpl borrowingDAO = (BorrowingDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BORROWINGDETAIL);
    BookServiceImpl bookServiceImpl = (BookServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.BOOKService);
    LogginServiceImpl logginServiceImpl = (LogginServiceImpl) ServiceFactory.getServiceFactory().getService(ServiceFactory.ServiceTypes.LOGGINService);

    @Override
    public boolean updateDueTransaction(int id){
        return borrowingDAO.updateDueDate(id);
    }

    @Override
    public List<BorrowingDetails> getDetails(int id){
        List<BorrowingDetails> list = borrowingDAO.getDetailsBYid(id);
       return list;
    }

    @Override
    public boolean saveBorrowingDetails(BorrowingDetailDTO borrowingDetailDTO){
        Book bookUsingID = bookServiceImpl.getBookUsingID(borrowingDetailDTO.getBookID());
        User userById = logginServiceImpl.getUserById(borrowingDetailDTO.getUserID());
        return borrowingDAO.saveAll(new BorrowingDetails(borrowingDetailDTO.getId(),borrowingDetailDTO.getBorrowingDate(),borrowingDetailDTO.getDueDate(),borrowingDetailDTO.getStatus(),userById,bookUsingID));
    }

    @Override
    public boolean updateStatus(int id) {

        return borrowingDAO.updateStatus(id);
    }
}
