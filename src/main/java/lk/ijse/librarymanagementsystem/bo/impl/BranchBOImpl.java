package lk.ijse.librarymanagementsystem.bo.impl;

import lk.ijse.librarymanagementsystem.dao.DAOFactory;
import lk.ijse.librarymanagementsystem.dao.impl.BranchDAOImpl;
import lk.ijse.librarymanagementsystem.dto.BranchDTO;
import lk.ijse.librarymanagementsystem.entity.Branches;
import lk.ijse.librarymanagementsystem.bo.BranchBO;

import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {

    BranchDAOImpl shopDAO = (BranchDAOImpl) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.SHOP);

    @Override
    public boolean deleteShop(int id){
        return shopDAO.deleteShop(id);
    }

    @Override
    public ArrayList<BranchDTO> getAllShops(){
        List<Branches> allShops = shopDAO.getAll();
        ArrayList<BranchDTO> arrayList = new ArrayList<>();
        for (Branches b : allShops){
            arrayList.add(new BranchDTO(b.getId(),b.getName(),b.getCity(),b.getAddress(),b.getPostalCode()));
        }
        return arrayList;
    }

    @Override
    public boolean saveShop(BranchDTO branchDTO){
        return shopDAO.saveAll(new Branches(branchDTO.getId(), branchDTO.getName(), branchDTO.getCity(), branchDTO.getAddress(), branchDTO.getPostalCode()));
    }

    @Override
    public Long getShopCount(){
        return shopDAO.getShopCount();
    }
}
