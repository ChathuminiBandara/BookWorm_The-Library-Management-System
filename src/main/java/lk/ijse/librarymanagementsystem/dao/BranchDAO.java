package lk.ijse.librarymanagementsystem.dao;

import lk.ijse.librarymanagementsystem.entity.Branches;

public interface BranchDAO extends CrudDAO<Branches> {
      Long getShopCount();
     boolean deleteShop(int id);
}
