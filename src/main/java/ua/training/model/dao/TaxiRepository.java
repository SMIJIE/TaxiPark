package ua.training.model.dao;

import ua.training.model.entity.Taxi;

import java.util.List;

/**
 * TaxiRepository
 * <p>
 * Description: This is the Interface with method for data from DataBase
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public interface TaxiRepository {
    void addNewTaxiObject();

    void deleteTaxiObjectById();

    List<Taxi> getAllTaxiObjects();
}
