package lk.ijse.librarymanagementsystem.dao;

import javafx.scene.control.Alert;
import lk.ijse.librarymanagementsystem.config.FactoryConfiguration;
import lk.ijse.librarymanagementsystem.entity.Branches;
import org.hibernate.Session;
import org.hibernate.query.Query;

public interface ShopDAO extends CrudDAO<Branches> {
      Long getShopCount();
     boolean deleteShop(int id);
}
