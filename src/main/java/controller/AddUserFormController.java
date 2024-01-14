package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AddUserFormController {

    @FXML
    private JFXButton btnInitiateRepairOrder;

    @FXML
    private JFXButton btnOrderDetails;

    @FXML
    private JFXButton btnProductStatus;

    @FXML
    private JFXButton btnFinalizePayment;

    @FXML
    private JFXButton btnSalseReport;

    @FXML
    private JFXButton btnAddUser;

    @FXML
    private JFXButton btnLogout;



    public void orderDetailsOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/OrderDetailsForm.fxml"))));
            stage.show();
            stage.setTitle("Order Details");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void productStatusONAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AllProductStatus.fxml"))));
            stage.show();
            stage.setTitle("All Product Status");

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    public void finalizePaymentOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/FinalizePayment.fxml"))));
            stage.show();
            stage.setTitle("Finalize Payment");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void salseReportOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/SalesReportForm.fxml"))));
            stage.show();
            stage.setTitle("Finalize Payment");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void addUserOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/AddUserForm.fxml"))));
            stage.show();
            stage.setTitle("Add User");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void logoutOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
            stage.show();
            stage.setTitle("Login Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void initiateRepairOrderOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InitializeRepairOrder.fxml"))));
            stage.show();
            stage.setTitle("Initiate Repai Order");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void itemOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ItemForm.fxml"))));
            stage.show();
            stage.setTitle("Item Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void customerOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/CustomerForm.fxml"))));
            stage.show();
            stage.setTitle("Customer Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

}
