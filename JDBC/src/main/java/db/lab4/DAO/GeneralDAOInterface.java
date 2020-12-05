package db.lab4.DAO;

import java.sql.SQLException;
import java.util.List;

public interface GeneralDAOInterface<T,ID> {

    List<T> getAll() throws SQLException;

    T getById(ID id) throws SQLException;

    int create(T entity) throws SQLException;

    int update(T entity) throws SQLException;

    int delete(ID id) throws SQLException;
}
