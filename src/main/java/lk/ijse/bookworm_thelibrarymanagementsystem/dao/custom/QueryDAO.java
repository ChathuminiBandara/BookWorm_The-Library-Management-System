package lk.ijse.bookworm_thelibrarymanagementsystem.dao.custom;

import lk.ijse.layeredarchitecture.dao.SuperDAO;
import lk.ijse.layeredarchitecture.dto.CustomDTO;

public interface QueryDAO extends SuperDAO {
    void customerOrderDetails(CustomDTO customDTO);
}
