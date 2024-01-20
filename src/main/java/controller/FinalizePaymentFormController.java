package controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.OrderDao;
import entity.Orders;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import javax.mail.Session;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;


import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;


public class FinalizePaymentFormController {

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
    private JFXTextField txtOrderId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtItemName;

    @FXML
    private JFXTextField txtServiceCharge;

    @FXML
    private JFXTextField txtExtraCost;

    @FXML
    private Label lblTotal;
    private String mail;

    private OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);
    public void initialize(){
        txtServiceCharge.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                double extraCost=Double.parseDouble(txtExtraCost.getText());
                double serviceCharge=Double.parseDouble(txtServiceCharge.getText());
                lblTotal.setText((extraCost+serviceCharge)+"");
            }


        });
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

    public void finalizeBillBtnOnAction(ActionEvent actionEvent) {
            double serviceCharge=Double.parseDouble(txtServiceCharge.getText());
            double extraCost=Double.parseDouble(txtExtraCost.getText());

             boolean r= orderDao.finalizeBillUpdate(txtOrderId.getText(),extraCost,serviceCharge);
            String message="\tThank you..! \n\n extra cost-Rs."+extraCost+"\n service Charge-Rs."+serviceCharge+"\n Total-Rs "+(extraCost+serviceCharge);
             sendEmail(mail,"Finalized Bill Payment",message);
            if(r){
                new Alert(Alert.AlertType.INFORMATION,"Bill is Finalaized and Email sent").show();
            }else{new Alert(Alert.AlertType.ERROR,"Bill is Not Finalaized").show();}



    }

    public void searchBtnOnAction(ActionEvent actionEvent) {
       Orders orders= orderDao.find(txtOrderId.getText());
       txtCustomerName.setText(orders.getCustomer().getCustomerName());
       txtItemName.setText(orders.getItem().getItemName());
       mail=orders.getCustomer().getCustomerEmail();

    }

    private  void sendEmail(String to, String subject, String message) {
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
            System.out.println("Email sent successfully to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
