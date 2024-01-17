package dao.custom.impl;

import dao.custom.OrderDao;
import entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {


    @Override
    public boolean save(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Order entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
