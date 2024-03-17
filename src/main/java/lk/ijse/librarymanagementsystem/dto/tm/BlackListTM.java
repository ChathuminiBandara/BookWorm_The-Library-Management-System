package lk.ijse.librarymanagementsystem.dto.tm;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlackListTM {
    private String transID;
    private String dueDate;
    private String BookId;
    private String booktitle;
    private String userId;
    private String username;
    private String userEmail;
}
