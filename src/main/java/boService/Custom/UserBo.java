package boService.Custom;

import boService.SuperBo;
import entity.User;

import java.sql.SQLException;

public interface UserBo extends SuperBo {

    boolean saveUser(User user) ;
    public boolean validation(String email,String password) ;
    User checkEmail(String email) ;
    void sendEmail(String to, String subject, String message);
}
