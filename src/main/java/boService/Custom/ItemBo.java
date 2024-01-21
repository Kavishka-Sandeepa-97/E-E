package boService.Custom;

import boService.SuperBo;
import dto.ItemDto;

import java.sql.SQLException;
import java.util.List;

public interface ItemBo extends SuperBo {
    boolean saveItem(ItemDto dto) ;
    boolean updateItem(ItemDto dto);
    boolean deleteItem(String id);
    List<ItemDto> allItem();

    ItemDto getItem(String id) ;

    String genarateId();

}
