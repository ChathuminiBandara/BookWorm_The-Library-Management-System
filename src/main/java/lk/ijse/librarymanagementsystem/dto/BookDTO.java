package lk.ijse.librarymanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String url;
}
