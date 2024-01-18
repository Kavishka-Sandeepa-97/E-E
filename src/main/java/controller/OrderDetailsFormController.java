package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.OrderDao;
import dto.OrderDto;
import entity.Customer;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailsFormController {

    public TreeTableColumn colDescription;
    public TreeTableColumn colExtraCost;
    public TreeTableColumn colServiceCharge;
    public JFXTextField txtItemName;
    public JFXTreeTableView<Orders> treeTable;
    public TreeTableColumn colItemId;
    public JFXTextField txtOrderID;
    @FXML
    private TreeTableColumn<?, ?> colOrderID;

    @FXML
    private TreeTableColumn<?, ?> colItemName;

    @FXML
    private TreeTableColumn<?, ?> colStatus;

    @FXML
    private TreeTableColumn<?, ?> colReciveDate;

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

    private OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);

    public void initialize(){
        loadOrderDetailsTable();

        colOrderID.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderId"));
        colDescription.setCellValueFactory(new TreeItemPropertyValueFactory<>("description"));
        colStatus.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));
        colReciveDate.setCellValueFactory(new TreeItemPropertyValueFactory<>("date"));
        colExtraCost.setCellValueFactory(new TreeItemPropertyValueFactory<>("extraCost"));
        colServiceCharge.setCellValueFactory(new TreeItemPropertyValueFactory<>("serviceCharge"));

    }

    private void loadOrderDetailsTable() {
        ObservableList<Orders> tmList = FXCollections.observableArrayList();
        List<Orders> list=null;
        try {
            list=orderDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        for(Orders orders:list){
            tmList.add(orders);
        }

        TreeItem<Orders> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
        treeTable.setRoot(treeItem);
        treeTable.setShowRoot(false);
    }


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
            stage.setResizable(false);
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

    public void salseReportOnAction(javafx.event.ActionEvent actionEvent) {
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

    public void addUserOnAction(javafx.event.ActionEvent actionEvent) {
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

    public void logoutOnAction(javafx.event.ActionEvent actionEvent) {
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

    public void initiateRepairOrderOnAction(javafx.event.ActionEvent actionEvent) {
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

    public void itemOnAction(javafx.event.ActionEvent actionEvent) {
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
