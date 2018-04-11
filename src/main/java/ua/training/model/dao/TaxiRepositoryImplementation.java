package ua.training.model.dao;

import ua.training.model.entity.Taxi;
import ua.training.model.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * TaxiRepositoryImplementation
 * <p>
 * Description: This is the Class implements {@link ua.training.model.dao.TaxiRepository}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class TaxiRepositoryImplementation implements TaxiRepository {
    private Connection connection = JdbcConnection.getInstance();
    private Statement query;
    private ResultSet rs;

    @Override
    public void addNewTaxiObject() {
    }

    @Override
    public void deleteTaxiObjectById() {
    }

    @Override
    public List<Taxi> getAllTaxiObjects() {
        List<Taxi> list = new ArrayList<>();
        Taxi taxi;

        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT `id`,`id_car`,`id_driver` FROM Taxi");

            while (rs.next()) {
                taxi = new Taxi(rs);
                list.add(taxi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
