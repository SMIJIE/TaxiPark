package ua.training.model.dao;

import ua.training.model.entity.Car;
import ua.training.model.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * CarRepositoryImplementation
 * <p>
 * Description: This is the Class implements {@link ua.training.model.dao.CarRepository}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class CarRepositoryImplementation implements CarRepository {

    private Connection connection = JdbcConnection.getInstance();
    private Statement query;
    private ResultSet rs;

    @Override
    public void addNewCar() {
    }

    @Override
    public void deleteCarById() {
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> list = new ArrayList<>();
        Car car;

        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT `id`,`carBrand`,`mark`,`price`," +
                    "`carClass`,`power`,`fuelConsumption`,`carNumber` FROM Car");

            while (rs.next()) {
                car = new Car(rs);
                list.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Car searchById(int id) {
        Car car = new Car();

        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT `id`,`carBrand`,`mark`,`price`," +
                    "`carClass`,`power`,`fuelConsumption`,`carNumber` FROM Car WHERE id=" + id);

            while (rs.next()) {
                car = new Car(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    @Override
    public int countrCars() {
        int count = 0;
        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT COUNT(*) FROM Car");

            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    @Override
    public long countPriceOfCars() {
        long price = 0;
        try {
            query = connection.createStatement();
            rs = query.executeQuery("SELECT SUM(`price`) FROM Car");

            while (rs.next()) {
                price = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }
}
