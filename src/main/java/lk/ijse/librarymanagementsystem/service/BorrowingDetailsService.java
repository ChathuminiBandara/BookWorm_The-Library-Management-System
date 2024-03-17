package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.Book;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;
import lk.ijse.librarymanagementsystem.entity.User;

import java.util.List;

public interface BorrowingDetailsService extends AllService {
     boolean updateDueTransaction(int id);
     List<BorrowingDetails> getDetails(int id);
     boolean saveBorrowingDetails(BorrowingDetailDTO borrowingDetailDTO);

     boolean updateStatus(int id);
}
