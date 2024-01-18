package boService.Custom.impl;

import boService.Custom.OrderBo;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.OrderDao;
import dto.OrderDto;
import dto.OrderTm;
import entity.Item;
import entity.Orders;
import org.hibernate.criterion.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrderBoImpl implements OrderBo {

private OrderDao orderDao=DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public boolean saveOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String genarateOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<OrderDto> allOrder() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genarateId() {
        Orders order = orderDao.lastOrder();
        if (order == null) {
            return ("ORD001");
        } else {
            String string = order.getOrderId();
            int id = Integer.parseInt(string.split("ORD")[1]);
            id++;
            return String.format("ORD%03d", id);
        }

    }

    @Override
    public List<OrderTm> PendingOrders() {
        List<OrderTm> orderTmList=new ArrayList<>();
        List<Orders> list=  orderDao.allPending();
        for(Orders orders:list){
            orderTmList.add(new OrderTm(
                    orders.getOrderId(),
                    orders.getDate(),
                    orders.getItem().getItemName(),
                    orders.getStatus()
            ));
        }
        return orderTmList;
    }

    @Override
    public List<OrderTm> ProcessingOrders() {
        List<OrderTm> orderTmList=new ArrayList<>();
        List<Orders> list=  orderDao.allProcessing();
        for(Orders orders:list){
            orderTmList.add(new OrderTm(
                    orders.getOrderId(),
                    orders.getDate(),
                    orders.getItem().getItemName(),
                    orders.getStatus()
            ));
        }
        return orderTmList;
    }

    @Override
    public List<OrderTm> completedOrders() {
        List<OrderTm> orderTmList=new ArrayList<>();
        List<Orders> list=  orderDao.allCompleded();
        for(Orders orders:list){
            orderTmList.add(new OrderTm(
                    orders.getOrderId(),
                    orders.getDate(),
                    orders.getItem().getItemName(),
                    orders.getStatus()
            ));
        }
        return orderTmList;
    }

}
