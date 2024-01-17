package boService.Custom.impl;

import boService.Custom.CustomerBo;
import dto.CustomerDto;
import java.sql.SQLException;
import java.util.List;

public class CustomerBoImpl implements CustomerBo {

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
}
