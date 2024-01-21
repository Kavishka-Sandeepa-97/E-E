package controller;

import boService.BoFactory;
import boService.BoType;
import boService.Custom.CustomerBo;
import boService.Custom.impl.CustomerBoImpl;
import boService.SuperBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dto.CustomerDto;
import entity.Customer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CustomerFormController {

    public Label lblCustomerID;
    public JFXTreeTableView<Customer> treeTableView;
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
    private JFXButton btnSalseReport1;

    @FXML
    private JFXButton btnSalseReport11;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private TreeTableColumn<?, ?> colCustomerID;

    @FXML
    private TreeTableColumn<?, ?> colCustomerName;

    @FXML
    private TreeTableColumn<?, ?> colCustomerEmail;

    @FXML
    private TreeTableColumn<?, ?> colCustomerPhone;

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private JFXTextField txtEmail;


    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtPhoneNumber;
    private CustomerBo customerBo= BoFactory.getInstance().getBo(BoType.CUSTOMER);
    public void initialize() {

        setOrderid();
        loadCustomerTable();
        colCustomerID.setCellValueFactory(new TreeItemPropertyValueFactory<>("customerId"));
        colCustomerName.setCellValueFactory(new TreeItemPropertyValueFactory<>("customerName"));
        colCustomerEmail.setCellValueFactory(new TreeItemPropertyValueFactory<>("customerEmail"));
        colCustomerPhone.setCellValueFactory(new TreeItemPropertyValueFactory<>("PhoneNumber"));
    }

    public void orderDetailsOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/OrderDetailsForm.fxml"))));
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
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AllProductStatus.fxml"))));
            stage.show();
            stage.setTitle("All Product Status");

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    public void finalizePaymentOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/FinalizePayment.fxml"))));
            stage.show();
            stage.setTitle("Finalize Payment");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void salseReportOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/SalesReportForm.fxml"))));
            stage.show();
            stage.setTitle("Finalize Payment");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void addUserOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/AddUserForm.fxml"))));
            stage.show();
            stage.setTitle("Add User");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void logoutOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/LoginForm.fxml"))));
            stage.show();
            stage.setTitle("Login Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void initiateRepairOrderOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/InitializeRepairOrder.fxml"))));
            stage.show();
            stage.setTitle("Initiate Repai Order");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void itemOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnAddUser.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml"))));
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
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerForm.fxml"))));
            stage.show();
            stage.setTitle("Customer Form");
            stage.setResizable(false);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    public void addCustomerOnAction(ActionEvent actionEvent) {

            customerBo.saveCustomer(new CustomerDto(
                 lblCustomerID.getText(),
                 txtCustomerName.getText(),
                 txtEmail.getText(),
                 Long.parseLong(txtPhoneNumber.getText())
            ));


        txtCustomerName.clear();
        txtEmail.clear();
        txtPhoneNumber.clear();
        setOrderid();
        loadCustomerTable();
    }

    public void setOrderid() {

            lblCustomerID.setText(customerBo.genarateId());

    }
    private void loadCustomerTable() {
        ObservableList<Customer> tmList = FXCollections.observableArrayList();
        List<Customer> customers = null;

            customers = customerBo.allCustomer();

        for(Customer customer:customers){
                tmList.add(customer);
            }

        TreeItem<Customer> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
        treeTableView.setRoot(treeItem);
        treeTableView.setShowRoot(false);
    }
}






