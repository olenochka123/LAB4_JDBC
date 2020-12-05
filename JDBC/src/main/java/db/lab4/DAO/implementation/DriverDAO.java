package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.Driver;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class DriverDAO implements GeneralDAOInterface<Driver, Integer> {

    private static final String GET_ALL = "SELECT * FROM Fito.driver";
    private static final String GET_BY_ID = "SELECT * FROM Fito.driver WHERE id=?";
    private static final String CREATE = "INSERT Fito.driver"
            + "(id,name,surname,last_name, age, telephone_number, email VALUES (?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE Fito.driver"
            + "SET name=?,surname=?,last_name=?, age=?, telephone_number=?, email=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM Fito.driver WHERE id=?";

    @Override
    public final List<Driver> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Driver> driver = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String last_name = resultSet.getString(4);
                    Integer age = resultSet.getInt(5);
                    String telephone_number = resultSet.getString(6);
                    String email = resultSet.getString(7);
                    driver.add(new Driver(id,name,surname,last_name, age, telephone_number, email));

                }

            }

        }
        return driver;
    }

    public final Driver getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Driver driver = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String surname = resultSet.getString(3);
                    String last_name = resultSet.getString(4);
                    Integer age = resultSet.getInt(5);
                    String telephone_number = resultSet.getString(6);
                    String email = resultSet.getString(7);
                    driver = new Driver(foundId, name,surname,last_name, age, telephone_number, email);
                }
            }
        }

        return driver;
    }

    @Override
    public final int create(final Driver entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getSurname());
            ps.setString(4, entity.getLastName());
            ps.setInt(5, entity.getAge());
            ps.setString(6, entity.getTelephoneNumber());
            ps.setString(7, entity.getEmail());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Driver entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getName());
            ps.setString(3, entity.getSurname());
            ps.setString(4, entity.getLastName());
            ps.setInt(5, entity.getAge());
            ps.setString(6, entity.getTelephoneNumber());
            ps.setString(7, entity.getEmail());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int delete(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(DELETE)) {
            ps.setInt(1, id);

            return ps.executeUpdate();
        }
    }


}