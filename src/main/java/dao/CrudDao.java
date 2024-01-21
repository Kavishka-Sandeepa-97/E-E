package dao;

import java.sql.SQLException;
import java.util.List;

public interface CrudDao<T> extends SuperDao{
    boolean save(T entity);
    boolean delete(String value) ;
    boolean update(T entity) ;
    List<T> getAll()  ;
}
