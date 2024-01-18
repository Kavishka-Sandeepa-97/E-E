package dao.custom;

import dao.CrudDao;
import entity.Item;
import entity.Orders;
import org.hibernate.criterion.Order;

public interface OrderDao extends CrudDao<Orders> {


     Orders lastOrder() ;



}
