package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.dto.ShopDTO;
import lk.ijse.librarymanagementsystem.entity.Branches;

import java.util.ArrayList;
import java.util.List;

public interface ShopService extends AllService{
     boolean deleteShop(int id);
     ArrayList<ShopDTO> getAllShops();
     boolean saveShop(ShopDTO shopDTO);
      Long getShopCount();
}
