package lk.ijse.librarymanagementsystem.bo.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.BorrowingDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.entity.User;
import lk.ijse.librarymanagementsystem.bo.BorrowingDetailsBO;
import lk.ijse.librarymanagementsystem.bo.ServiceBO;

import java.util.List;

public class BorrowingDetailsBOImpl implements BorrowingDetailsBO {
    BorrowingDAOImpl borrowingDAO = (BorrowingDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BORROWINGDETAIL);
    BookBOImpl bookServiceImpl = (BookBOImpl) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.BOOKService);
    LogginBOImpl logginServiceImpl = (LogginBOImpl) ServiceBO.getServiceFactory().getService(ServiceBO.ServiceTypes.LOGGINService);

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
