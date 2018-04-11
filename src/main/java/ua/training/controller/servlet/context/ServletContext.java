package ua.training.controller.servlet.context;

import ua.training.controller.command.*;
import ua.training.controller.service.TaxiDAOImplementation;
import ua.training.model.jdbc.JdbcConnection;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static ua.training.view.View.bundle;

/**
 * ServletContext
 * <p>
 * Description: First initialization of data before Servlets
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
@WebListener
public class ServletContext implements ServletContextListener {
    private Map<String, Command> commands;
    private TaxiDAOImplementation taxiDAOImplementation;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        commands = new ConcurrentHashMap();

        commands.put("showCars", new ShowCars());
        commands.put("sortCarsByClass", new SortCarsByClass());
        commands.put("sortCarsByFuelConsumption", new SortCarsByFuelConsumption());
        commands.put("sortCarsByPrice", new SortCarsByPrice());
        commands.put("sortCarsByPower", new SortCarsByPower());
        commands.put("initialException", new InitialException());
        commands.put("changeLanguage", new ChangeLanguage());
        commands.put("welcomePage", new WelcomePage());

        taxiDAOImplementation = new TaxiDAOImplementation();

        int tempCount = taxiDAOImplementation.countrCars();
        long tempPrice = taxiDAOImplementation.countPriceOfCars();

        servletContextEvent.getServletContext().setAttribute("taxiParkPrice", tempPrice);
        servletContextEvent.getServletContext().setAttribute("numberOfCars", tempCount);

        servletContextEvent.getServletContext().setAttribute("commands", commands);

        servletContextEvent.getServletContext().setAttribute("localeLang", bundle.getLocale());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        commands = null;
        JdbcConnection.closeInstance();
    }
}
