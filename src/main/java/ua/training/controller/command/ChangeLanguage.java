package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

/**
 * ChangeLanguage
 * <p>
 * Description: This is the Class change language(Locale)
 * {@link ua.training.view.View}
 * <p>
 * Created: 09.04.2018
 * <p>
 * Updated:
 *
 * @author Zakusylo Pavlo
 */
public class ChangeLanguage implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String temp = request.getParameter("lan");
        request.getServletContext().setAttribute("localeLang", temp);

        return "redirect:/index.jsp";
    }
}
