package dao.custom.impl;

import dao.custom.UserDao;
import dao.util.HibernateUtil;
import entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean save(User entity)  {
        Session session= HibernateUtil.getSession();
        Transaction transaction = session.beginTransaction();
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
    public boolean update(User entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
