package lk.ijse.librarymanagementsystem.bo;

import lk.ijse.librarymanagementsystem.bo.impl.BookBOImpl;
import lk.ijse.librarymanagementsystem.bo.impl.BorrowingDetailsBOImpl;
import lk.ijse.librarymanagementsystem.bo.impl.LogginBOImpl;
import lk.ijse.librarymanagementsystem.bo.impl.BranchBOImpl;

public class ServiceBO {
    private static ServiceBO factory;
    private ServiceBO() {
    }
    public static ServiceBO getServiceFactory(){
        return (factory == null) ? factory =new ServiceBO() : factory;
    }
    public enum ServiceTypes{
        BOOKService,BORROWINGDETAILService,LOGGINService,SHOPService
    }
    public superBo getService(ServiceTypes daoTypes){
        switch (daoTypes){
            case BOOKService: return new BookBOImpl();
            case BORROWINGDETAILService: return new BorrowingDetailsBOImpl();
            case LOGGINService: return new LogginBOImpl();
            case SHOPService: return new BranchBOImpl();
            default: return null;
        }
    }
}
