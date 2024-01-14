package controller;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class LoginFormController {

    public BorderPane loginPane;
    @FXML
    private Button btnSignIn;

    @FXML
    private JFXButton btnForgot;

    public void signInButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) loginPane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InitializeRepairOrder.fxml"))));
            stage.show();
            stage.setTitle("Inetialize Repair Order");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void forgotbtnOnAction(ActionEvent actionEvent) {

    }
}
