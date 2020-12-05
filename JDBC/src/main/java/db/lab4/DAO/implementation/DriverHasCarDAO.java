package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.DriverHasCar;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DriverHasCarDAO implements GeneralDAOInterface<DriverHasCar, Integer> {

    private static final String GET_ALL = "SELECT * FROM Fito.driver_has_car";
    private static final String GET_BY_ID = "SELECT * FROM Fito.driver_has_car WHERE id=?";
    private static final String CREATE = "INSERT Fito.driver_has_car"
            + "(id,driver_id,car_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE Fito.driver_has_car"
            + "SET driver_id=?,car_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM Fito.driver_has_car WHERE id=?";

    @Override
    public final List<DriverHasCar> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<DriverHasCar> driverHasCar = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer driver_id = resultSet.getInt(2);
                    Integer car_id = resultSet.getInt(3);
                    driverHasCar.add(new DriverHasCar(driver_id, car_id));

                }

            }

        }
        return driverHasCar;
    }

    @Override
    public final DriverHasCar getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        DriverHasCar driverHasCar = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer driver_id = resultSet.getInt(2);

                    driverHasCar = new DriverHasCar(foundId, driver_id);
                }
            }
        }
        return driverHasCar;
    }

    @Override
    public final int create(final DriverHasCar entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getDriverId());
            ps.setInt(3, entity.getCarId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final DriverHasCar entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getDriverId());
            ps.setInt(2, entity.getCarId());
            ps.setInt(3, entity.getId());

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