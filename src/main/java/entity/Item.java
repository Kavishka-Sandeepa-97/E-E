package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Item {
    @Id
    String itemCode;
    String itemName;
    String Brand;

    @OneToMany(mappedBy = "item")
    List<Order> orderList=new ArrayList<>();

}
