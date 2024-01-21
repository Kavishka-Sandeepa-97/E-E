package controller;
import antlr.actions.cpp.ActionLexer;
import boService.BoFactory;
import boService.BoType;
import boService.Custom.UserBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {

    public BorderPane loginPane;
    public JFXPasswordField txtPassword;
    public JFXTextField txtEmail;
    @FXML
    private Button btnSignIn;

    @FXML
    private JFXButton btnForgot;
    private UserBo userBo= BoFactory.getInstance().getBo(BoType.USER);
    public void signInButtonOnAction(ActionEvent actionEvent) {

        boolean validation = false;

            validation = userBo.validation(txtEmail.getText(), txtPassword.getText());

        if (validation) {
            Stage stage = (Stage) loginPane.getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InitializeRepairOrder.fxml"))));
                stage.show();
                stage.setTitle("Inetialize Repair Order");
                stage.setResizable(false);
            } catch (IOException e) {

                throw new RuntimeException(e);
            }
        }else {new Alert(Alert.AlertType.ERROR,"Password Or Email Incorect").show();
        }
    }

    public void forgotbtnOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) loginPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ForgotPasswordForm.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();
        stage.setTitle("Inetialize Repair Order");
        stage.setResizable(false);
    }
}
