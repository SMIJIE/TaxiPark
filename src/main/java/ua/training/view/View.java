package ua.training.view;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * view
 * <p>
 * Description: This class for displaying actions
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */

public class View {
    public static final String SORT_BY_PRICE = "input.string.price";
    public static final String SORT_BY_POWER = "input.string.power";
    public static final String SORT_BY_CLASS = "input.string.carClass";
    public static final String SORT_BY_FUEL_CONSUMPTION = "input.string.fuelConsumption";

    public static String MESSREG_BUNDLE_NAME = "mess";
    public static ResourceBundle bundle = ResourceBundle.getBundle(MESSREG_BUNDLE_NAME,
            new Locale("en"));
}