package boService.Custom.impl;

import boService.Custom.CustomerBo;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDaoImpl;
import dto.CustomerDto;
import dto.OrderDto;
import entity.Customer;

import java.sql.SQLException;
import java.util.List;


public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao= new CustomerDaoImpl();

    @Override
    public boolean saveCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<CustomerDto> allCustomer() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genarateId() {

            Customer customer= customerDao.lastOrder();
            if (customer == null) {
                return ("C001");
            } else {
                String string = customer.getCustomerId();
                int id = Integer.parseInt(string.split("C")[1]);
                id++;
                return String.format("D%03d", id);
            }

        }

}
