package boService.Custom.impl;

import boService.Custom.CustomerBo;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.CustomerDao;
import dao.custom.impl.CustomerDaoImpl;
import dto.CustomerDto;
import dto.OrderDto;
import entity.Customer;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;


public class CustomerBoImpl implements CustomerBo {
    private CustomerDao customerDao= DaoFactory.getInstance().getDao(DaoType.CUSTOMER);

    @Override
    public boolean saveCustomer(CustomerDto dto)  {
      return   customerDao.save(new Customer(
                dto.getCustomerId(),
                dto.getCustomerName(),
                dto.getCustomerEmail(),
                dto.getCustomerPhoneNumber()
        ));

    }

    @Override
    public boolean updateCustomer(CustomerDto dto) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public List<Customer> allCustomer() {

        return customerDao.getAll();
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
                return String.format("C%03d", id);
            }

        }

}
