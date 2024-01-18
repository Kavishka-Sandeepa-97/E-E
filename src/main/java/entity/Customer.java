package entity;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Customer extends RecursiveTreeObject<Customer> {


    @Id
    String CustomerId;
    String customerName;
    String customerEmail;
    long phoneNumber;

    @OneToMany(mappedBy = "customer")
    List<Orders> ordersList =new ArrayList<>();

    public Customer(String customerId, String customerName, String customerEmail, long phoneNumber) {
        CustomerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.phoneNumber = phoneNumber;
    }
    public Customer(String customerId) {
        CustomerId = customerId;
    }
}
