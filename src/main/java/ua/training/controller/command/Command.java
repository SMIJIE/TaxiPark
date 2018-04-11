package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * command
 * <p>
 * Description: This is the main Inteface with method from servlet
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public interface Command {
    String execute(HttpServletRequest request);
}
