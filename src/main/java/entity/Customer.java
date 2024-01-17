package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    String CustomerId;
    String customerName;
    String customerEmail;
    long phoneNumber;

    @OneToMany(mappedBy = "customer")
    List<Orders> ordersList =new ArrayList<>();
}
