package dao;

import dao.custom.impl.CustomerDaoImpl;
import dao.custom.impl.ItemDaoImpl;
import dao.custom.impl.OrderDaoImpl;
import dao.custom.impl.UserDaoImpl;
import entity.User;

public class DaoFactory {

    static DaoFactory daoFactory;
    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }
    public <T extends SuperDao>T getDao(DaoType type){
        switch (type){
            case CUSTOMER:return (T) new CustomerDaoImpl();
            case ITEM:return (T) new ItemDaoImpl();
            case ORDER: return (T) new OrderDaoImpl();
            case USER: return (T) new UserDaoImpl();
        }
        return null;
    }
}
