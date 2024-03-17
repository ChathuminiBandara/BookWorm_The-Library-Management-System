package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface LogginService extends AllService {
      Long getUserCount();
     User getUserById(int id);

     ArrayList<UserDTO> getAllUsers();
     ArrayList<AdminDTO> getAllAdmins();
     boolean saveAdmin(AdminDTO adminDTO);
     boolean saveUser(UserDTO userDTO);
     boolean updateAdmin(AdminDTO adminDTO);
     boolean updateUser(UserDTO userDTO);
}
