package lk.ijse.librarymanagementsystem.dao;

import lk.ijse.librarymanagementsystem.dao.impl.*;

public class DAOFactory {
    private static DAOFactory factory;
    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory(){
        return (factory == null) ? factory =new DAOFactory() : factory;
    }
    public enum DAOTypes{
        ADMIN,BOOK,BORROWINGDETAIL,SHOP,USER
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ADMIN: return new AdminDAOImpl();
            case USER: return new UserDAOImpl();
            case BOOK: return new BookDAOImpl();
            case SHOP: return new ShopDAOImpl();
            case BORROWINGDETAIL: return new BorrowingDAOImpl();
            default: return null;
        }
    }
}
