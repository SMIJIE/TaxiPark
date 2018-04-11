package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * InitialException
 * <p>
 * Description: This is the Class generated runtime exception
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class InitialException implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        throw new RuntimeException("Generated exception");
    }
}
