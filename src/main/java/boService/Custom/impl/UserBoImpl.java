package boService.Custom.impl;

import boService.Custom.UserBo;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.UserDao;
import entity.User;
import javafx.scene.control.Alert;
import org.mindrot.jbcrypt.BCrypt;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class UserBoImpl implements UserBo {

    private UserDao userDao= DaoFactory.getInstance().getDao(DaoType.USER);

    @Override
    public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
       String password= user.getPassword();

       String hased= BCrypt.hashpw(password,BCrypt.gensalt());
        user.setPassword(hased);
        return userDao.save(user);
    }
    public boolean validation(String email,String password) throws SQLException, ClassNotFoundException {
        List<User> list= userDao.getAll();
        if(list.isEmpty()){
            return true;
        }else {
        for(User user:list){
            if(user.getEmail().equalsIgnoreCase(email) && BCrypt.checkpw(password,user.getPassword())){
                return true;
                }
            }

         }
        return false;
    }

    @Override
    public User checkEmail(String mail) throws SQLException, ClassNotFoundException {
        List<User> list=userDao.getAll();
        for(User user:list){
            if (user.getEmail().equalsIgnoreCase(mail)){
                return user;
            }
        }
        return null;
    }
    @Override
    public void sendEmail(String to, String subject, String message) {
        // Replace these values with your email configuration
        String from = "kavishkapk99@gmail.com";
        String password = "eiqm qrsf icer sicp";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(from));
            emailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            Transport.send(emailMessage);
            new Alert(Alert.AlertType.INFORMATION,"Email sent successfully to " + to).show();

        } catch (MessagingException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Please Input Valid Email " + to).show();
        }
    }

}
