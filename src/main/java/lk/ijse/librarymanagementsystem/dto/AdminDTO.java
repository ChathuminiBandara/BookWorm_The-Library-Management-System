package lk.ijse.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class AdminDTO {
    private int id;
    private String username;
    private String password;
    private String email;
}
