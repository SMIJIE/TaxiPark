package ua.training.controller.command;

import ua.training.controller.service.TaxiDAOImplementation;
import ua.training.model.entity.Taxi;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * WelcomePage
 * <p>
 * Description: This is the Class return welcome-file {web.file}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class WelcomePage implements Command {
    private TaxiDAOImplementation taxiDAOImplementation;

    @Override
    public String execute(HttpServletRequest request) {
        taxiDAOImplementation = new TaxiDAOImplementation();
        List<Taxi> list = taxiDAOImplementation.getAllTaxiObjects();

        int tempPrice = 0;
        for (Taxi taxi : list) {
            tempPrice += taxi.getCar().getPrice();
        }

        request.setAttribute("numberOfCars", list.size());
        request.setAttribute("taxiParkPrice", tempPrice);

        return "/index.jsp";
    }
}
