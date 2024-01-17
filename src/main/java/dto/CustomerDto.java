package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class CustomerDto {
    String CustomerId;
    String customerName;
    String customerEmail;
    long phoneNumber;
}
