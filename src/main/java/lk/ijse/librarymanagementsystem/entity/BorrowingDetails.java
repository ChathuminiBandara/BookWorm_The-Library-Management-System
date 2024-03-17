package lk.ijse.librarymanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BorrowingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String borrowingDate;
    private String dueDate;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private User User;
    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;

}
