package db.lab4.DAO.implementation;

import db.lab4.DAO.GeneralDAOInterface;
import db.lab4.model.implementation.PostOffice;
import db.lab4.persistance.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.LinkedList;

public class PostOfficeDAO implements GeneralDAOInterface<PostOffice, Integer> {

    private static final String GET_ALL = "SELECT * FROM Fito.post_office";
    private static final String GET_BY_ID = "SELECT * FROM Fito.post_office WHERE id=?";
    private static final String CREATE = "INSERT Fito.post_office"
            + "(id,capacity,phone_number,hours_of_working VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE Fito.post_office"
            + "SET capacity=?,phone_number=?,hours_of_working=? WHERE id=? ";
    private static final String DELETE = "DELETE FROM Fito.post_office WHERE id=?";

    @Override
    public final List<PostOffice> getAll() throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        List<PostOffice> postOffice = new LinkedList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    Integer id = resultSet.getInt(1);
                    Integer capacity = resultSet.getInt(2);
                    String phone_number = resultSet.getString(3);
                    String hours_of_working = resultSet.getString(4);
                    postOffice.add(new PostOffice(id, capacity,phone_number,hours_of_working));

                }

            }

        }
        return postOffice;
    }

    public final PostOffice getById(final Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        PostOffice postOffice = null;

        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Integer foundId = resultSet.getInt(1);
                    Integer capacity = resultSet.getInt(2);
                    String phone_number = resultSet.getString(3);
                    String hours_of_working = resultSet.getString(4);
                    postOffice = new PostOffice(foundId, capacity,phone_number,hours_of_working);
                }
            }
        }

        return postOffice;
    }

    @Override
    public final int create(final PostOffice entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(CREATE)) {
            ps.setInt(1, entity.getId());
            ps.setInt(2, entity.getCapacity());
            ps.setString(3, entity.getPhoneNumber());
            ps.setString(4, entity.getHoursOfWorking());
            return ps.executeUpdate();
        }
    }

    @Override
    public final int update(final PostOffice entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getCapacity());
            ps.setString(2, entity.getPhoneNumber());
            ps.setString(3, entity.getHoursOfWorking());
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