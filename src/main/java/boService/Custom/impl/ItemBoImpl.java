package boService.Custom.impl;

import boService.Custom.ItemBo;
;
import dto.ItemDto;


import java.sql.SQLException;

import java.util.List;

public class ItemBoImpl implements ItemBo {

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
}
