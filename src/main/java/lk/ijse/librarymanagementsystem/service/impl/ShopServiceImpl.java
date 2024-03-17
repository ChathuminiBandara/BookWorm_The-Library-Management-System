package lk.ijse.librarymanagementsystem.service.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.ShopDAOImpl;
import lk.ijse.librarymanagementsystem.dto.ShopDTO;
import lk.ijse.librarymanagementsystem.entity.Branches;
import lk.ijse.librarymanagementsystem.service.ShopService;

import java.util.ArrayList;
import java.util.List;

public class ShopServiceImpl implements ShopService {

    ShopDAOImpl shopDAO = (ShopDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);

    @Override
    public boolean deleteShop(int id){
        return shopDAO.deleteShop(id);
    }

    @Override
    public ArrayList<ShopDTO> getAllShops(){
        List<Branches> allShops = shopDAO.getAll();
        ArrayList<ShopDTO> arrayList = new ArrayList<>();
        for (Branches b : allShops){
            arrayList.add(new ShopDTO(b.getId(),b.getName(),b.getCity(),b.getAddress(),b.getPostalCode()));
        }
        return arrayList;
    }

    @Override
    public boolean saveShop(ShopDTO shopDTO){
        return shopDAO.saveAll(new Branches(shopDTO.getId(), shopDTO.getName(), shopDTO.getCity(), shopDTO.getAddress(), shopDTO.getPostalCode()));
    }

    @Override
    public Long getShopCount(){
        return shopDAO.getShopCount();
    }
}
