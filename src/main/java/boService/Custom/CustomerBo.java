package boService.Custom;

import boService.SuperBo;
import dto.CustomerDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerBo extends SuperBo {
    boolean saveCustomer(CustomerDto dto) ;
    boolean updateCustomer(CustomerDto dto);
    boolean deleteCustomer(String id) ;
    List<Customer> allCustomer();

    String genarateId();
}
