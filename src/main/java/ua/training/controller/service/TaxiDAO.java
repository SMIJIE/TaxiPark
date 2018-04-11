package ua.training.controller.service;

import ua.training.model.entity.Car;
import ua.training.model.entity.Driver;
import ua.training.model.entity.Taxi;

import java.util.List;

/**
 * TaxiDAO
 * <p>
 * Description: This is the main Interface with method for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public interface TaxiDAO {
    void addNewCar();

    void deleteCarById();

    List<Car> getAllCars();

    Car searchCarById(int id);

    int countrCars();

    long countPriceOfCars();

    void addNewDriver();

    void deleteDriverById();

    List<Driver> getAllDrivers();

    Driver searchDriverById(int id);

    void addNewTaxiObject();

    void deleteTaxiObjectById();

    List<Taxi> getAllTaxiObjects();
}
