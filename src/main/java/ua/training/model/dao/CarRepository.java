package ua.training.model.dao;

import ua.training.model.entity.Car;

import java.util.List;

/**
 * CarRepository
 * <p>
 * Description: This is the Interface with method for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public interface CarRepository {
    void addNewCar();

    void deleteCarById();

    List<Car> getAllCars();

    Car searchById(int id);

    int countrCars();

    long countPriceOfCars();
}
