package lk.ijse.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowingDetailDTO {
    private int id;
    private String borrowingDate;
    private String dueDate;
    private String status;
    private int UserID;
    private int BookID;
}
