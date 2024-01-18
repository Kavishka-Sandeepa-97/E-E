package dto;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class OrderTm extends RecursiveTreeObject<OrderTm> {
    String orderID;
    String reciveDate;
    String item;
    String status;

}
