package lk.ijse.librarymanagementsystem.bo;

import lk.ijse.librarymanagementsystem.dto.BorrowingDetailDTO;
import lk.ijse.librarymanagementsystem.entity.BorrowingDetails;

import java.util.List;

public interface BorrowingDetailsBO extends superBo {
     boolean updateDueTransaction(int id);
     List<BorrowingDetails> getDetails(int id);
     boolean saveBorrowingDetails(BorrowingDetailDTO borrowingDetailDTO);

     boolean updateStatus(int id);
}
