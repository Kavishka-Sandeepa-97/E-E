package boService.Custom.impl;

import boService.Custom.UserBo;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.UserDao;
import entity.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.SQLException;

public class UserBoImpl implements UserBo {
    private UserDao userDao= DaoFactory.getInstance().getDao(DaoType.USER);

    @Override
    public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
       String password= user.getPassword();

       String hased= BCrypt.hashpw(password,BCrypt.gensalt());
        user.setPassword(hased);
        return userDao.save(user);
    }
}
