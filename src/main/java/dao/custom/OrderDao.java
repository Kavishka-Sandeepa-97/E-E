package dao.custom;

import dao.CrudDao;
import entity.Item;
import entity.Orders;
import org.hibernate.criterion.Order;

import java.util.List;

public interface OrderDao extends CrudDao<Orders> {


     Orders lastOrder() ;
     List<Orders> allPending();
     List<Orders> allProcessing();
     List<Orders>allCompleded();
     String getStatus(String orderID);
     public boolean setStatus(String status,String id);

}
