package lk.ijse.librarymanagementsystem.dao;

import lk.ijse.librarymanagementsystem.entity.Admin;

public interface AdminDAO extends CrudDAO<Admin>{
     boolean updateAdmin(Admin admin);
}
