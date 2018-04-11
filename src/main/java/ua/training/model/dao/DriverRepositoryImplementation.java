package ua.training.model.dao;

import ua.training.model.entity.Driver;
import ua.training.model.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DriverRepositoryImplementation
 * <p>
 * Description: This is the Class implements {@link ua.training.model.dao.DriverRepository}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class DriverRepositoryImplementation implements DriverRepository {
    private Connection connection = JdbcConnection.getInstance();
    private Statement query;
    private ResultSet rs;

    @Override
    public void addNewDriver() {
    }

    @Override
    public void deleteDriverById() {
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();
        Driver driver;

        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT `id`,`name`,`surname`,`age`," +
                    "`rights`,`workExperience`,`rightsNumber` FROM Driver");

            while (rs.next()) {
                driver = new Driver(rs);
                list.add(driver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Driver searchById(int id) {
        Driver driver = null;

        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT `id`,`name`,`surname`,`age`," +
                    "`rights`,`workExperience`,`rightsNumber` FROM Driver WHERE id=" + id);

            while (rs.next()) {
                driver = new Driver(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }
}
