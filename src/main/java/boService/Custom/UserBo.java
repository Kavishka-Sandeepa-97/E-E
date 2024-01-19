package boService.Custom;

import boService.SuperBo;
import entity.User;

import java.sql.SQLException;

public interface UserBo extends SuperBo {

    boolean saveUser(User user) throws SQLException, ClassNotFoundException;
}
