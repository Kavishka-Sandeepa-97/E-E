package dao.custom.impl;

import dao.custom.OrderDao;
import dao.util.HibernateUtil;
import entity.Customer;
import entity.Item;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {


    @Override
    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String value) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<Orders> getAll() throws SQLException, ClassNotFoundException {
        Session session=HibernateUtil.getSession();
        Query fromCustomer = session.createQuery("From Orders");
        List list = fromCustomer.list();
        return list;
    }

    @Override
    public Orders lastOrder() {
        Orders lastRow=null;
        Session session= HibernateUtil.getSession();
        Query<Orders> query = session.createQuery("FROM Orders ORDER BY OrderID DESC", Orders.class);

        query.setMaxResults(1);
        lastRow = query.uniqueResult();
        return lastRow;
    }

    @Override
    public List<Orders> allPending() {
        String hql = "SELECT o FROM Orders o WHERE o.status = 'Pending'";
        Session session= HibernateUtil.getSession();
        Query<Orders> query = session.createQuery(hql, Orders.class);
        List<Orders> list = query.getResultList();

        return list;
    }

    @Override
    public List<Orders> allProcessing() {
        String hql = "SELECT o FROM Orders o WHERE o.status = 'Processing'";
        Session session= HibernateUtil.getSession();
        Query<Orders> query = session.createQuery(hql, Orders.class);
        List<Orders> list= query.getResultList();
        return list;
    }

    @Override
    public List<Orders> allCompleded() {
        String hql = "SELECT o FROM Orders o WHERE o.status = 'completed'";
        Session session= HibernateUtil.getSession();
        Query<Orders> query = session.createQuery(hql, Orders.class);
        List<Orders> list = query.getResultList();
        return list;
    }

    @Override
    public String getStatus(String orderID) {

        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            Orders orders = session.find(Orders.class, orderID);

            return orders.getStatus();
        }catch (NullPointerException e){
            return null;
        }
    }
    public boolean setStatus(String id,String status){
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();

        Orders orders=session.find(Orders.class,id);

        orders.setStatus(status);

        session.save(orders);
        transaction.commit();
        return true;
    }

    @Override
    public Orders find(String id) {
        Session session=HibernateUtil.getSession();
        Orders orders=session.find(Orders.class,id);
        return orders;
    }

    @Override
    public boolean finalizeBillUpdate(String id, double extra, double service) {
        Session session=HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();

        Orders orders=session.find(Orders.class,id);

        orders.setStatus("CLOSED");
        orders.setExtraCost(extra);
        orders.setServiceCharge(service);

        session.save(orders);
        transaction.commit();
        return true;
    }
}
