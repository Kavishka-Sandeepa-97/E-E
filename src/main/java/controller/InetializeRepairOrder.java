package controller;

import boService.BoFactory;
import boService.BoType;
import boService.Custom.OrderBo;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.CustomerDao;
import dao.custom.ItemDao;
import dao.custom.OrderDao;
import dto.CustomerDto;
import dto.ItemDto;
import dto.OrderDto;
import entity.Customer;
import entity.Item;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class InetializeRepairOrder {

    public JFXComboBox cmbItemName;
    public JFXComboBox cmbCustomerName;
    public Label lblItemID;
    public Label LblCustomerID;
    public JFXTextField txtCustomerEmail;
    public JFXTextField txtCustomerPone;
    public Label lblOrderID;
    public JFXTextArea txtDescription;
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

    private List<Customer> custlist;
    private List<Item> itemlist;
    private ItemDao itemDao= DaoFactory.getInstance().getDao(DaoType.ITEM);
    private CustomerDao customerDao=DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    private OrderBo orderBo= BoFactory.getInstance().getBo(BoType.ORDER);

    private OrderDao orderDao=DaoFactory.getInstance().getDao(DaoType.ORDER);

public void initialize() {

    setOrderid();

    loadCustomerIds();
    loadItemeCodes();
    cmbCustomerName.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
        for (Customer customer : custlist) {
            if (customer.getCustomerName().equals(newValue)) {
                LblCustomerID.setText(customer.getCustomerId());
                txtCustomerEmail.setText(customer.getCustomerEmail());
                txtCustomerPone.setText(customer.getPhoneNumber()+"");
                return;
            }
            ;
        }
    });
    cmbItemName.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
        for (Item item : itemlist) {
            if (item.getItemName().equals(newValue)) {
                lblItemID.setText(item.getItemCode());
                return;
            }
            ;
        }
    });
}

    private void loadCustomerIds() {
        ObservableList<String> list = FXCollections.observableArrayList();

            custlist = customerDao.getAll();
            for (Customer x : custlist) {
                list.add(x.getCustomerName());
            }
            cmbCustomerName.setItems(list);



    }

    private void loadItemeCodes() {

        ObservableList<String> list = FXCollections.observableArrayList();

            itemlist = itemDao.getAll();
            for (Item x : itemlist) {
                list.add(x.getItemName());
            }
            cmbItemName.setItems(list);



    }



    private void setOrderid() {
        lblOrderID.setText(orderBo.genarateId());

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

    public void salseReportOnAction(ActionEvent actionEvent) {
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

    public void addUserOnAction(ActionEvent actionEvent) {
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

    public void logoutOnAction(ActionEvent actionEvent) {
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

    public void initiateRepairOrderOnAction(ActionEvent actionEvent) {
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

    public void itemOnAction(ActionEvent actionEvent) {
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

    public void InitiateRepairOrderOnAction(ActionEvent actionEvent) {

            boolean save = orderDao.save(new Orders(
                    lblOrderID.getText(),
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("YY-MM-dd")),
                    txtDescription.getText(),
                    "PENDING",
                    0.0,
                    0.0,
                    new Customer(LblCustomerID.getText(),(String) cmbCustomerName.getValue(),txtCustomerEmail.getText(),Long.parseLong(txtCustomerPone.getText())),
                    new Item(lblItemID.getText())
            ));
            if (save){
                Stage stage = (Stage) btnAddUser.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/InitializeRepairOrder.fxml"))));
                    stage.show();
                    stage.setTitle("Initiate Repai Order");
                    stage.setResizable(false);
                } catch (IOException e) {

                    throw new RuntimeException(e);
                }
                new Alert(Alert.AlertType.INFORMATION, "Order is Initialized").show();

            }


    }
}
