package lk.ijse.librarymanagementsystem.service;

import lk.ijse.librarymanagementsystem.service.impl.BookServiceImpl;
import lk.ijse.librarymanagementsystem.service.impl.BorrowingDetailsServiceImpl;
import lk.ijse.librarymanagementsystem.service.impl.LogginServiceImpl;
import lk.ijse.librarymanagementsystem.service.impl.ShopServiceImpl;

public class ServiceFactory {
    private static ServiceFactory factory;
    private ServiceFactory() {
    }
    public static ServiceFactory getServiceFactory(){
        return (factory == null) ? factory =new ServiceFactory() : factory;
    }
    public enum ServiceTypes{
        BOOKService,BORROWINGDETAILService,LOGGINService,SHOPService
    }
    public AllService getService(ServiceTypes daoTypes){
        switch (daoTypes){
            case BOOKService: return new BookServiceImpl();
            case BORROWINGDETAILService: return new BorrowingDetailsServiceImpl();
            case LOGGINService: return new LogginServiceImpl();
            case SHOPService: return new ShopServiceImpl();
            default: return null;
        }
    }
}
