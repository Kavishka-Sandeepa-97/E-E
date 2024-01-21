package controller;

import boService.BoFactory;
import boService.BoType;
import boService.Custom.UserBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.UserDao;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;

public class ForgotPasswordFormController {

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtOTP;

    @FXML
    private JFXButton btnSendOtp;

    @FXML
    private JFXButton btnSavePassword;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnLogout;

    private int r;
    private User u;
    private UserBo userBo= BoFactory.getInstance().getBo(BoType.USER);
    private UserDao userDao= DaoFactory.getInstance().getDao(DaoType.USER);
    public void logoutOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnSavePassword.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
            stage.show();
            stage.setTitle("Login Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void sendOtpOnaction(ActionEvent actionEvent)  {

        Random random = new Random();

        int min = 1000;
        int max = 9999;
         r = random.nextInt(max - min + 1) + min;

        User  user = userBo.checkEmail(txtEmail.getText());
        u=user;
        if (user==null){
            new Alert(Alert.AlertType.ERROR,"Input Valid Email").show();
            return;
        }
        userBo.sendEmail(txtEmail.getText(),"OTP Message","Your OPT is "+r);
    }

    public void savePasswordOnAction(ActionEvent actionEvent){
        String email=txtEmail.getText();
        String password=txtPassword.getText();
        String otp=txtOTP.getText();
        String hased= BCrypt.hashpw(password,BCrypt.gensalt());
        u.setPassword(hased);
        boolean update = false;

            update = userDao.update(u);

        if(update && otp.equalsIgnoreCase(String.valueOf(r))){
            new Alert(Alert.AlertType.INFORMATION,"Password is Updated").show();
        }else  new Alert(Alert.AlertType.INFORMATION,"wrong !").show();
    }


}
