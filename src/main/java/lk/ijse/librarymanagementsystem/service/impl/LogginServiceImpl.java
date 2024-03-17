package lk.ijse.librarymanagementsystem.service.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.AdminDAOImpl;
import lk.ijse.librarymanagementsystem.dao.impl.UserDAOImpl;
import lk.ijse.librarymanagementsystem.dto.AdminDTO;
import lk.ijse.librarymanagementsystem.dto.UserDTO;
import lk.ijse.librarymanagementsystem.entity.Admin;
import lk.ijse.librarymanagementsystem.entity.User;
import lk.ijse.librarymanagementsystem.service.LogginService;

import java.util.ArrayList;
import java.util.List;

public class LogginServiceImpl implements LogginService {

    UserDAOImpl userDAO = (UserDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);
    AdminDAOImpl adminDAO = (AdminDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ADMIN);

    @Override
    public User getUserById(int id){
        return userDAO.getUserByID(id);
    }

    @Override
    public ArrayList<UserDTO> getAllUsers(){
        ArrayList<UserDTO> arrayList = new ArrayList<>();
        List<User> allUser = userDAO.getAll();
        for (User u : allUser){
            arrayList.add(new UserDTO(u.getId(),u.getUsername(),u.getPassword(),u.getEmail()));
        }
        return arrayList;
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins(){
        ArrayList<AdminDTO> arrayList = new ArrayList<>();
        for (Admin a : adminDAO.getAll()){
            arrayList.add(new AdminDTO(a.getId(),a.getUsername(),a.getPassword(),a.getEmail()));
        }
        return arrayList;
    }

    @Override
    public boolean saveAdmin(AdminDTO adminDTO){
        return adminDAO.saveAll(new Admin(adminDTO.getId(),adminDTO.getUsername(),adminDTO.getPassword(),adminDTO.getEmail()));
    }
    @Override
    public boolean saveUser(UserDTO userDTO){
        return userDAO.saveAll(new User(userDTO.getId(),userDTO.getUsername(),userDTO.getPassword(),userDTO.getEmail(),new ArrayList<>()));
    }

    @Override
    public boolean updateAdmin(AdminDTO adminDTO){
        return adminDAO.updateAdmin(new Admin(adminDTO.getId(),adminDTO.getUsername(),adminDTO.getPassword(),adminDTO.getEmail()));
    }

    @Override
    public boolean updateUser(UserDTO userDTO){
        return userDAO.updateUser(new User(userDTO.getId(),userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail(),new ArrayList<>()));

    }

    @Override
    public Long getUserCount(){
        return userDAO.getUserCount();
    }
}
