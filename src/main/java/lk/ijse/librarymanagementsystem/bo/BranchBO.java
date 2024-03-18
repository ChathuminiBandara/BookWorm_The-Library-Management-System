package lk.ijse.librarymanagementsystem.bo;

import lk.ijse.librarymanagementsystem.dto.BranchDTO;

import java.util.ArrayList;

public interface BranchBO extends superBo {
     boolean deleteShop(int id);
     ArrayList<BranchDTO> getAllShops();
     boolean saveShop(BranchDTO branchDTO);
      Long getShopCount();
}
