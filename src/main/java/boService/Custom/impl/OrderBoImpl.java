package boService.Custom.impl;

import boService.Custom.OrderBo;
import dto.OrderDto;
import java.sql.SQLException;
import java.util.List;


public class OrderBoImpl implements OrderBo {


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
}
