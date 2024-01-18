package dto;

import entity.Customer;
import entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class OrderDto {
    @Getter
    @Setter
    @AllArgsConstructor
    public class Orders {

        String OrderId;
        String date;
        String description;
        double extraCost;
        double serviceCharge;

        private String customerId;
        private String  itemCode;

    }
}
