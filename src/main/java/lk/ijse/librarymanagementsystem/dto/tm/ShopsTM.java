package lk.ijse.librarymanagementsystem.dto.tm;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopsTM {
    private String id;
    private String name;
    private String city;
    private String address;
    private String postalCode;
    private JFXButton update;
    private JFXButton delete;
}
