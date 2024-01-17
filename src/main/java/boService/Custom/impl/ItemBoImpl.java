package boService.Custom.impl;

import boService.Custom.ItemBo;
;
import dao.DaoFactory;
import dao.DaoType;
import dao.custom.ItemDao;
import dto.ItemDto;
import entity.Customer;
import entity.Item;


import java.sql.SQLException;

import java.util.List;

public class ItemBoImpl implements ItemBo {
    ItemDao itemDao= DaoFactory.getInstance().getDao(DaoType.ITEM);

    @Override
    public boolean saveItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public List<ItemDto> allItem() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ItemDto getItem(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public String genarateId() {
        Item item= itemDao.lastItem();
        if (item == null) {
            return ("ITM001");
        } else {
            String string = item.getItemCode();
            int id = Integer.parseInt(string.split("ITM")[1]);
            id++;
            return String.format("ITM%03d", id);
        }

    }


}
