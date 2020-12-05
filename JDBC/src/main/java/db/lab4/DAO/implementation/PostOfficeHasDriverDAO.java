package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.PostOfficeHasDriver;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PostOfficeHasDriverDAO implements GeneralDAOInterface<PostOfficeHasDriver, Integer> {

    private static final String GET_ALL = "SELECT * FROM Fito.post_office_has_driver";
    private static final String GET_BY_ID = "SELECT * FROM Fito.post_office_has_driver WHERE id=?";
    private static final String CREATE = "INSERT Fito.post_office_has_driver"
            + "(id,post_office_id,driver_id) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE Fito.post_office_has_driver"
            + "SET post_office_id=?,driver_id=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM Fito.post_office_has_driver WHERE id=?";

    @Override
    public final List<PostOfficeHasDriver> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PostOfficeHasDriver> postOfficeHasDriver = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer post_office_id = resultSet.getInt(2);
                    Integer driver_id = resultSet.getInt(3);
                    postOfficeHasDriver.add(new PostOfficeHasDriver(post_office_id, driver_id));

                }

            }

        }
        return postOfficeHasDriver;
    }

    @Override
    public final PostOfficeHasDriver getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PostOfficeHasDriver postOfficeHasDriver = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer post_office_id = resultSet.getInt(2);

                    postOfficeHasDriver = new PostOfficeHasDriver(foundId, post_office_id);
                }
            }
        }
        return postOfficeHasDriver;
    }

    @Override
    public final int create(final PostOfficeHasDriver entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getPostOfficeId());
            ps.setInt(3, entity.getDriverId());

            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PostOfficeHasDriver entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getPostOfficeId());
            ps.setInt(2, entity.getDriverId());
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