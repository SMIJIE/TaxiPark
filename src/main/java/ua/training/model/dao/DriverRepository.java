package ua.training.model.dao;

import ua.training.model.entity.Driver;

import java.util.List;

/**
 * DriverRepository
 * <p>
 * Description: This is the Interface with method for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public interface DriverRepository {
    void addNewDriver();

    void deleteDriverById();

    List<Driver> getAllDrivers();

    Driver searchById(int id);
}
