package lk.ijse.librarymanagementsystem.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BooksTM {
    private String id;
    private String title;
    private String author;
    private String genre;
    private String status;
    private String url;
    private JFXButton update;
    private JFXButton delete;
}
