package ua.training.controller.command;

import ua.training.controller.service.TaxiDAOImplementation;
import ua.training.model.entity.Taxi;
import ua.training.view.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * SortCarsByClass
 * <p>
 * Description: This is the Class selected all entity from dataBase sort by class of car
 * {@link ua.training.model.entity.Car}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class SortCarsByClass implements Command {
    private TaxiDAOImplementation taxiDAOImplementation;

    @Override
    public String execute(HttpServletRequest request) {
        taxiDAOImplementation = new TaxiDAOImplementation();
        List<Taxi> list = taxiDAOImplementation.getAllTaxiObjects();

        Collections.sort(list, new Comparator<Taxi>() {
            @Override
            public int compare(Taxi o1, Taxi o2) {
                return o1.getCar().getCarClass().compareTo(o2.getCar().getCarClass());
            }
        });

        request.setAttribute("taxiObjects", list);
        request.setAttribute("parametrSort", View.SORT_BY_CLASS);

        return "/allCars.jsp";
    }
}
