package boService.Custom;

import boService.SuperBo;
import dto.OrderDto;
import dto.OrderTm;

import java.sql.SQLException;
import java.util.List;

public interface OrderBo extends SuperBo {

    public boolean saveOrder(OrderDto orderDto) throws SQLException, ClassNotFoundException;
    public  String genarateOrderId() throws SQLException, ClassNotFoundException;

    public List<OrderDto> allOrder() throws SQLException, ClassNotFoundException;

    String genarateId();

    List<OrderTm> PendingOrders();
    List<OrderTm> ProcessingOrders();
    List<OrderTm> completedOrders();
}
