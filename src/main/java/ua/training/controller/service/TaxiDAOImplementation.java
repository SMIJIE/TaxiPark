package ua.training.controller.service;

import ua.training.model.dao.CarRepositoryImplementation;
import ua.training.model.dao.DriverRepositoryImplementation;
import ua.training.model.dao.TaxiRepositoryImplementation;
import ua.training.model.entity.Car;
import ua.training.model.entity.Driver;
import ua.training.model.entity.Taxi;

import java.util.List;

/**
 * CarRepositoryImplementation
 * <p>
 * Description: This is the Class implements {@link ua.training.controller.service.TaxiDAO}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class TaxiDAOImplementation implements TaxiDAO {
    private CarRepositoryImplementation carRepositoryImplementation = new CarRepositoryImplementation();
    private DriverRepositoryImplementation driverRepositoryImplementation = new DriverRepositoryImplementation();
    private TaxiRepositoryImplementation taxiRepositoryImplementation = new TaxiRepositoryImplementation();

    @Override
    public void addNewCar() {
        carRepositoryImplementation.addNewCar();
    }

    @Override
    public void deleteCarById() {
        carRepositoryImplementation.deleteCarById();
    }

    @Override
    public List<Car> getAllCars() {
        return carRepositoryImplementation.getAllCars();
    }

    @Override
    public Car searchCarById(int id) {
        return carRepositoryImplementation.searchById(id);
    }

    @Override
    public int countrCars() {
        return carRepositoryImplementation.countrCars();
    }

    @Override
    public long countPriceOfCars() {
        return carRepositoryImplementation.countPriceOfCars();
    }

    @Override
    public void addNewDriver() {
        driverRepositoryImplementation.addNewDriver();
    }

    @Override
    public void deleteDriverById() {
        driverRepositoryImplementation.deleteDriverById();
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverRepositoryImplementation.getAllDrivers();
    }

    @Override
    public Driver searchDriverById(int id) {
        return driverRepositoryImplementation.searchById(id);
    }

    @Override
    public void addNewTaxiObject() {
        taxiRepositoryImplementation.addNewTaxiObject();
    }

    @Override
    public void deleteTaxiObjectById() {
        taxiRepositoryImplementation.deleteTaxiObjectById();
    }

    @Override
    public List<Taxi> getAllTaxiObjects() {
        return taxiRepositoryImplementation.getAllTaxiObjects();
    }
}
