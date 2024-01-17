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

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Item extends RecursiveTreeObject<Item> {


    @Id
    String itemCode;
    String itemName;

    @OneToMany(mappedBy = "item")
    List<Orders> ordersList =new ArrayList<>();
    public Item(String itemCode, String itemName) {
        this.itemCode = itemCode;
        this.itemName = itemName;
    }

}
