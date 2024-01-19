package boService.Custom;

import boService.SuperBo;
import entity.User;

import java.sql.SQLException;

public interface UserBo extends SuperBo {

    boolean saveUser(User user) throws SQLException, ClassNotFoundException;
    public boolean validation(String email,String password) throws SQLException, ClassNotFoundException;
}
