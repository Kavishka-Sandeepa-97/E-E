package controller;

import boService.BoFactory;
import boService.BoType;
import boService.Custom.OrderBo;
import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.OrderDao;
import dto.OrderTm;
import entity.Customer;
import entity.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AllProductStatusFormController {

    public JFXTreeTableView<OrderTm> pendingTreeTableView;
    public JFXTreeTableView<OrderTm> ProcessingTreeTableView;
    public JFXTreeTableView<OrderTm> completedTreeTableView;
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


    @FXML
    private TreeTableColumn<?, ?> colPendingOrderID;

    @FXML
    private TreeTableColumn<?, ?> colPendingReciveDate;

    @FXML
    private TreeTableColumn<?, ?> colPendingItem;

    @FXML
    private TreeTableColumn<?, ?> colPendingStatusS;

    @FXML
    private JFXTextField txtID;

    @FXML
    private TreeTableColumn<?, ?> colProcessingOrderId;

    @FXML
    private TreeTableColumn<?, ?> colProcessingReciveDate;

    @FXML
    private TreeTableColumn<?, ?> colIProcessingtem;

    @FXML
    private TreeTableColumn<?, ?> colProcesingStatus;

    @FXML
    private TreeTableColumn<?, ?> colCompletedOrderId;

    @FXML
    private TreeTableColumn<?, ?> colCompletedReciveDate;

    @FXML
    private TreeTableColumn<?, ?> colICompletedtem;

    @FXML
    private TreeTableColumn<?, ?> colCompletedStatus;

    @FXML
    private JFXTextField txtCurrentStatus;

    @FXML
    private JFXComboBox<String> cmbStatus;

    private OrderBo orderBo= BoFactory.getInstance().getBo(BoType.ORDER);
    private OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);

    public void initialize(){
        loadPendingTable();
        loadProcessingTable();
        loadCompletedTable();

        loadStatus();
        colPendingOrderID.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderID"));
        colPendingReciveDate.setCellValueFactory(new TreeItemPropertyValueFactory<>("reciveDate"));
        colPendingItem.setCellValueFactory(new TreeItemPropertyValueFactory<>("item"));
        colPendingStatusS.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

        colProcessingOrderId.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderID"));
        colProcessingReciveDate.setCellValueFactory(new TreeItemPropertyValueFactory<>("reciveDate"));
        colIProcessingtem.setCellValueFactory(new TreeItemPropertyValueFactory<>("item"));
        colProcesingStatus.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

        colCompletedOrderId.setCellValueFactory(new TreeItemPropertyValueFactory<>("orderID"));
        colCompletedReciveDate.setCellValueFactory(new TreeItemPropertyValueFactory<>("reciveDate"));
        colICompletedtem.setCellValueFactory(new TreeItemPropertyValueFactory<>("item"));
        colCompletedStatus.setCellValueFactory(new TreeItemPropertyValueFactory<>("status"));

    }

    private void loadStatus() {
        ObservableList<String> list = FXCollections.observableArrayList();

                list.add("PROCESSING");
                list.add("COMPLETED");
               cmbStatus.setItems(list);


    }

    private void loadCompletedTable() {
        ObservableList<OrderTm> tmList = FXCollections.observableArrayList();
        List<OrderTm> listOrderTm=orderBo.completedOrders();
        for(OrderTm tm:listOrderTm){
            tmList.add(tm);
        }

        TreeItem<OrderTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
        completedTreeTableView.setRoot(treeItem);
        completedTreeTableView.setShowRoot(false);
    }



    private void loadProcessingTable() {
        ObservableList<OrderTm> tmList = FXCollections.observableArrayList();
        List<OrderTm> listOrderTm=orderBo.ProcessingOrders();
        for(OrderTm tm:listOrderTm){
            tmList.add(tm);
        }

        TreeItem<OrderTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
        ProcessingTreeTableView.setRoot(treeItem);
        ProcessingTreeTableView.setShowRoot(false);
    }

    private void loadPendingTable() {
        ObservableList<OrderTm> tmList = FXCollections.observableArrayList();
        List<OrderTm> listOrderTm=orderBo.PendingOrders();
        for(OrderTm tm:listOrderTm){
            tmList.add(tm);
        }

        TreeItem<OrderTm> treeItem = new RecursiveTreeItem<>(tmList, RecursiveTreeObject::getChildren);
        pendingTreeTableView.setRoot(treeItem);
        pendingTreeTableView.setShowRoot(false);
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

    public void changeStatusButtonOnAction(ActionEvent actionEvent) {
        orderDao.setStatus(txtID.getText(),(String) cmbStatus.getValue());
        loadCompletedTable();
        loadPendingTable();
        loadProcessingTable();
    }

    public void searchButtonOnAction(ActionEvent actionEvent) {
        String status= orderDao.getStatus(txtID.getText());
        if(status==null){
            new Alert(Alert.AlertType.ERROR, "Order ID Not Found").show();
            return;
        }
        txtCurrentStatus.setText(status);
    }

}
