package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.Car;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class CarDAO implements GeneralDAOInterface<Car, Integer> {

    private static final String GET_ALL = "SELECT * FROM Fito.car";
    private static final String GET_BY_ID = "SELECT * FROM Fito.car WHERE id=?";
    private static final String CREATE = "INSERT Fito.car"
            + "(id,brand,number,color VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE Fito.car"
            + "SET brand=?,number=?,color=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM Fito.car WHERE id=?";

    @Override
    public final List<Car> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<Car> car = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    String brand = resultSet.getString(2);
                    Integer number = resultSet.getInt(3);
                    String color = resultSet.getString(4);
                    car.add(new Car(id, brand, number, color));

                }

            }

        }
        return car;
    }

    public final Car getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        Car car = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    String brand = resultSet.getString(2);
                    Integer number = resultSet.getInt(3);
                    String color = resultSet.getString(4);
                    car = new Car(foundId, brand, number, color);
                }
            }
        }

        return car;
    }

    @Override
    public final int create(final Car entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getBrand());
            ps.setInt(3, entity.getNumber());
            ps.setString(4, entity.getColor());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final Car entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setString(1, entity.getBrand());
            ps.setInt(2, entity.getNumber());
            ps.setString(3, entity.getColor());
            ps.setInt(4, entity.getId());

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