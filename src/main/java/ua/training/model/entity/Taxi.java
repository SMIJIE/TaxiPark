package ua.training.model.entity;

import ua.training.controller.service.TaxiDAOImplementation;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Taxi
 * <p>
 * Description: This is the entity for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class Taxi {
    private int id;
    private Car car;
    private Driver driver;

    public Taxi(int id, Car car, Driver driver) {
        this.id = id;
        this.car = car;
        this.driver = driver;
    }

    public Taxi(ResultSet resultSet) {
        TaxiDAOImplementation taxiDAOImplementation = new TaxiDAOImplementation();
        try {
            this.id = (Integer.valueOf(resultSet.getString("id")));
            this.car = taxiDAOImplementation.searchCarById(resultSet.getInt("id_car"));
            this.driver = taxiDAOImplementation.searchDriverById(resultSet.getInt("id_driver"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Taxi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "car=" + car +
                ", driver=" + driver +
                '}';
    }
}
